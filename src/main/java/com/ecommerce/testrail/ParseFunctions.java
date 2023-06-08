package com.ecommerce.testrail;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public final class ParseFunctions {

    public static JSONObject parseTestNGResults(String filePath) {
        File testNGResults = new File(filePath);
        try {
            // Parse current JSON record, attach to new test results
            Scanner sc = new Scanner(testNGResults);
            StringBuilder fileStringBuilder = new StringBuilder();
            while(sc.hasNextLine()) fileStringBuilder.append(sc.nextLine());
            org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
            sc.close();
            return (JSONObject)parser.parse(fileStringBuilder.toString());
        } catch (IOException e) {
            System.out.println("Results not found at " + filePath + ". Are TestNG tests running?");
            return new JSONObject();
        } catch (ParseException e) {
            System.out.println("JSON file at " + filePath + " could not be parsed.");
            return new JSONObject();
        }
    }

    @SuppressWarnings("unchecked")
    public static JSONObject parseCucumberResults(String filePath) {
        File cucumberResults = new File(filePath);
        JSONArray rawResults;
        try {
            // Parse current JSON record, attach to new test results
            Scanner sc = new Scanner(cucumberResults);
            StringBuilder fileStringBuilder = new StringBuilder();
            while(sc.hasNextLine()) fileStringBuilder.append(sc.nextLine());
            JSONParser parser = new JSONParser();
            sc.close();
            rawResults = (JSONArray) parser.parse(fileStringBuilder.toString());
        } catch (IOException e) {
            System.out.println("Results not found at " + filePath + ". Are Cucumber tests running?");
            return new JSONObject();
        } catch (ParseException e) {
            System.out.println("JSON file at " + filePath + " could not be parsed.");
            return new JSONObject();
        }
        JSONObject processedResults = new JSONObject();
        for(Object testReportObj : rawResults) {
            String featureName = (String)((JSONObject)testReportObj).get("name");
            HashMap<String, String> featureReport = new HashMap<>();
            processedResults.put(featureName, featureReport);
            for(Object elementObj : (JSONArray) ((JSONObject)testReportObj).get("elements"))  {
                String scenarioName = (String)((JSONObject)elementObj).get("name");
                if(featureReport.containsKey(scenarioName)) {
                    int i = 1;
                    while(processedResults.containsKey(scenarioName + " (" + i + ")")) i++;
                    scenarioName+= " (" + i + ")";
                }
                featureReport.put(scenarioName, "passed");
                JSONArray[] allSteps =  new  JSONArray[]{(JSONArray) ((JSONObject)elementObj).get("before"), (JSONArray) ((JSONObject)elementObj).get("steps"), (JSONArray) ((JSONObject)elementObj).get("after"), };
                boolean failed = false;
                for(JSONArray stepSetObj : allSteps) {
                    for(Object step : stepSetObj) {
                        String result = (String)((JSONObject)((JSONObject)step).get("result")).get("status");
                        if(!(result.equalsIgnoreCase("passed"))) {
                            featureReport.put(scenarioName, result);
                            failed = true;
                            break;
                        }
                    }
                    if(failed) break;
                }
            }
        }
        return processedResults;
    }
}

