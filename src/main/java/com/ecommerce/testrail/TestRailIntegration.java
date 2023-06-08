package com.ecommerce.testrail;

import com.codepine.api.testrail.TestRail;
import com.codepine.api.testrail.model.*;
import org.json.simple.JSONObject;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class TestRailIntegration {

    // TestRail API wrapper configuration
    private final static String TESTRAIL_ENDPOINT = "https://ecommerce.testrail.com";
    private final static String TESTRAIL_USER = "testrailapiuser@ecommerce.com";
    private final static String TESTRAIL_API_KEY = "";
    private final static int PROJECT_ID = 19;
    private final static TestRail testRail = TestRail.builder(TESTRAIL_ENDPOINT, TESTRAIL_USER, TESTRAIL_API_KEY).build();
    private final static Project project = testRail.projects().get(PROJECT_ID).execute();
    private final static List<Integer> caseIds = new ArrayList<>();
    private final static List<Result> results = new ArrayList<>();
    private final static List<CaseField> caseFields = testRail.caseFields().list().execute();
    private final static List<ResultField> resultFields = testRail.resultFields().list().execute();
    private final static HashMap<String, Integer> sectionToId = new HashMap<>();
    private final static HashMap<String, Integer> testCaseToId = new HashMap<>();

    private static void discoverExistingTests() {
        for (Case c : testRail.cases().list(project.getId(), caseFields).execute()) {
            testCaseToId.put(c.getTitle(), c.getId());
        }
        for (Section s : testRail.sections().list(project.getId()).execute()) {
            sectionToId.put(s.getName(), s.getId());
        }
    }

    private static HashMap<String, JSONObject> defineTestGroups() {
        HashMap<String, JSONObject> testGroups = new HashMap<>();
        testGroups.put("Automated TestNG Tests", ParseFunctions.parseTestNGResults("build/reports/testng-report.json"));
        testGroups.put("Automated Cucumber Tests", ParseFunctions.parseCucumberResults("build/reports/cucumber-report.json"));
        return testGroups;

    }

    @SuppressWarnings("unchecked")
    private static void addTestGroup(String testGroup, JSONObject testResults) {
        Section groupSection;
        if (sectionToId.containsKey(testGroup)) {
            groupSection = testRail.sections().get(sectionToId.get(testGroup)).execute();
        } else {
            groupSection = testRail.sections().add(project.getId(), new Section().setName(testGroup)).execute();
        }
        List<String> testsInGroup = new ArrayList<>(((HashMap<String, HashMap<String, String>>) testResults).keySet());
        Collections.sort(testsInGroup);
        for (String testFile : testsInGroup) {
            HashMap<String, String> tests = ((HashMap<String, HashMap<String, String>>) testResults).get(testFile);
            ArrayList<String> testNames = new ArrayList<>(tests.keySet());
            Collections.sort(testNames);
            Section fileSubsection;
            if (sectionToId.containsKey(testFile)) {
                fileSubsection = testRail.sections().get(sectionToId.get(testFile)).execute();
            } else {
                fileSubsection = testRail.sections().add(project.getId(), new Section().setName(testFile).setParentId(groupSection.getId())).execute();
            }
            for (String testName : testNames) {
                Case testCase;
                if (testCaseToId.containsKey(testName)) {
                    testCase = testRail.cases().get(testCaseToId.get(testName), caseFields).execute();
                } else {
                    testCase = testRail.cases().add(fileSubsection.getId(), new Case().setTitle(testName), caseFields).execute();
                }
                Result testResult = new Result().setCaseId(testCase.getId()).setStatusId(tests.get(testCase.getTitle()).equalsIgnoreCase("passed") ? 1 : 5);
                results.add(testResult);
                caseIds.add(testCase.getId());
            }
        }
    }

    private static String getNameFromArgs(String[] args) {
        String env = args[0];
        String branch = args[1];
        String shortName = branch.toUpperCase();
        if(branch.equals("UNKNOWN") || branch.equals("master")) {
            shortName = env.toUpperCase();
        }
        // Parse out ticket from branch name
        else if(branch.split("/").length > 2) {
            shortName = branch.split("/")[1];
        }
        String formattedTimestamp = DateTimeFormatter.ofPattern("M/d/yy, h:mm a").format(LocalDateTime.now().atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneId.of("America/New_York")));
        return "Automated Tests [" + shortName + "] - " + formattedTimestamp;
    }

    private static void sendResults(String runName) {
        Run testRun = testRail.runs().add(PROJECT_ID, new Run().setName(runName).setIncludeAll(false).setCaseIds(caseIds)).execute();
        testRail.results().addForCases(testRun.getId(), results, resultFields).execute();
    }

    public static void main(String[] args) {
        discoverExistingTests();
        HashMap<String, JSONObject> testResults = defineTestGroups();
        ArrayList<String> testGroupNames = new ArrayList<>(testResults.keySet());
        Collections.sort(testGroupNames);
        for(String groupName : testGroupNames) {
            addTestGroup(groupName, testResults.get(groupName));
        }
        if(results.isEmpty()) {
            System.out.println("No results found. Terminating.");
            return;
        } else {
            String runName = getNameFromArgs(args);
            sendResults(runName);
        }
    }
}

