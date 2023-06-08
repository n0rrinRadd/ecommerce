package com.ecommerce.testrail;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.IInvokedMethod;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ITestNGMethod;
import org.testng.xml.XmlSuite;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings("unchecked")
public class JSONReporter implements IReporter {

    private final static String[] EXCLUDED_FUNCTIONS = new String[]{"initialize", "After", "startManagedChannel", "shutdownManagedChannel", "BeforeMethod", "Before"};
    private final static String OUTPUT_FILE = "/testng-report.json";

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        HashMap<String, HashMap<String, String>> testResults = new HashMap<>();
        // Convert test results to HashMap in order to be parsed as JSON
        for(ISuite suite : suites) {
            for (IInvokedMethod invokedMethod : suite.getAllInvokedMethods()) {
                ITestNGMethod testMethod = invokedMethod.getTestMethod();
                String testName = testMethod.getMethodName();
                String className = testMethod.getTestClass().getName();
                // Functions annotated with @Before, @After, etc. are included in "all invoked methods"
                // They aren't tests, though, so we don't want to report them.
                if (Arrays.asList(EXCLUDED_FUNCTIONS).contains(testName)) continue;
                if (!(testResults.containsKey(className))) testResults.put(className, new HashMap<>());
                String result = invokedMethod.getTestResult().isSuccess() ? "passed" : "failed";
                testResults.get(className).put(testName, result);
            }
        }
        // Add JSON from this file's HashMap to JSON from any other files
        // Creates a JSON structure {file1: {test1: status, test2: status,...}, file2: {...}}
        try {
            JSONObject jsonOut = new JSONObject(testResults);
            File jsonFile = new File(outputDirectory + OUTPUT_FILE);
            if(!(jsonFile.exists())) {
                jsonFile.createNewFile();
            } else {
                // Parse current JSON record, attach to new test results
                Scanner sc = new Scanner(jsonFile);
                StringBuilder fileStringBuilder = new StringBuilder();
                while(sc.hasNextLine()) fileStringBuilder.append(sc.nextLine());
                JSONParser parser = new JSONParser();
                JSONObject jsonIn = (JSONObject)parser.parse(fileStringBuilder.toString());
                jsonOut.putAll(jsonIn);
                sc.close();
            }
            PrintWriter writer = new PrintWriter(jsonFile);
            writer.write(jsonOut.toJSONString());
            writer.close();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
