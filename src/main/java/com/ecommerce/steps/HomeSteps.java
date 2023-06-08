package com.ecommerce.steps;

import com.ecommerce.pages.storefront.base.BasePage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class HomeSteps {

    WebDriver driver;
    BasePage basePage;

    private BaseDriver baseDriver;

    public HomeSteps(BaseDriver baseDriver) {
        this.baseDriver = baseDriver;
        this.driver = baseDriver.getDriver();
    }

    @Given("I am on the homepage")
    public void i_am_on_the_homepage() throws PendingException {
        basePage = new BasePage(driver);
        basePage.goTo();
    }
}