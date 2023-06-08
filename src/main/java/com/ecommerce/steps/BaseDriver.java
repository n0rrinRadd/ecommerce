package com.ecommerce.steps;

import com.ecommerce.driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BaseDriver {

    private static boolean initialized = false;
    public static String testName;

    private WebDriver driver;

    @Before
    public void setup(Scenario scenario){
        if (!initialized){
            testName = scenario.getName();
            initialized = true;
        }
    }

    public WebDriver getDriver(){
        return driver;
    }

    public WebDriver getDesktopDriver(){
        System.setProperty("browserView", "desktop");
        System.setProperty("browserMode", "gui");
        driver = new DriverFactory().getDriver(testName);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public WebDriver getMobileDriver(){
        System.setProperty("browserView", "mobile");
        System.setProperty("browserMode", "gui");
        driver = new DriverFactory().getDriver(testName);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }

    public WebDriver getHeadlessDriver(){
        System.setProperty("browserView", "desktop");
        System.setProperty("browserMode", "headless");
        driver = new DriverFactory().getDriver(testName);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }

    @After
    public void tearDownDriver(){
        initialized = false;
        driver.quit();
    }
}
