package com.ecommerce.steps;

import com.ecommerce.pages.storefront.base.BasePage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class ecommerceLandingPageSteps {

    WebDriver driver;

    private BaseDriver baseDriver;

    public ecommerceLandingPageSteps(BaseDriver baseDriver) {
        this.baseDriver = baseDriver;
        this.driver = baseDriver.getDriver();
    }

    @Given("I navigate to a ecommerce landing page")
    public void i_am_on_a_ecommerce_landing_page() throws PendingException {
        BasePage basePage = new BasePage(driver);
        basePage.goTo("/app/content/healthcare-ecommerce");
    }
}