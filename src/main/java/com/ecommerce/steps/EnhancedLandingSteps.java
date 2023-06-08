package com.ecommerce.steps;

import com.ecommerce.pages.storefront.base.BasePage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class EnhancedLandingSteps {

    WebDriver driver;
    BasePage basePage;

    private BaseDriver baseDriver;

    public EnhancedLandingSteps(BaseDriver baseDriver) {
        this.baseDriver = baseDriver;
        this.driver = baseDriver.getDriver();
    }

    @Given("I navigate to an enhanced landing page")
    public void i_am_on_an_enhanced_landing_page() throws PendingException {
        BasePage basePage = new BasePage(driver);
        basePage.goTo("/cc/top-digestive-health-supplements-11118");
    }
}