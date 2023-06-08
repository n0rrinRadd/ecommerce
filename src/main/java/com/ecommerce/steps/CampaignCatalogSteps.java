package com.ecommerce.steps;

import com.ecommerce.pages.storefront.base.BasePage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class CampaignCatalogSteps {

    WebDriver driver;
    BasePage basePage;

    private BaseDriver baseDriver;

    public CampaignCatalogSteps(BaseDriver baseDriver) {
        this.baseDriver = baseDriver;
        this.driver = baseDriver.getDriver();
    }

    @Given("I navigate to a campaign catalog page")
    public void i_am_on_a_campaign_catalog_page() throws PendingException {
        BasePage basePage = new BasePage(driver);
        basePage.goTo("/cc/");
    }
}