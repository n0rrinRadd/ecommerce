package com.ecommerce.steps;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class BaseSteps {

    WebDriver driver;

    private BaseDriver baseDriver;

    public BaseSteps(BaseDriver baseDriver) {
        this.baseDriver = baseDriver;
    }

    @Given("I am on a {} browser")
    public void i_am_on_a_x_browser(String device){
        if (device == null) {
            device = "desktop";
        }
        switch (device.toLowerCase()) {
            case "desktop":
                this.driver = baseDriver.getDesktopDriver();
                break;
            case "mobile":
                this.driver = baseDriver.getMobileDriver();
                break;
            case "headless":
                this.driver = baseDriver.getHeadlessDriver();
                break;
            default:
                break;
        }
    }
}