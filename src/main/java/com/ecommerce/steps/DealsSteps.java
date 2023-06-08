package com.ecommerce.steps;

import com.ecommerce.helpers.Environment;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;

public class DealsSteps {

    WebDriver driver;

    private BaseDriver baseDriver;

    public DealsSteps(BaseDriver baseDriver) {
        this.baseDriver = baseDriver;
        this.driver = baseDriver.getDriver();
    }

    @And("I click on the {} deal")
    public void i_click_on_the_deals_button(String deal) {
        switch (deal) {
            case "cat food":
                driver.navigate().to((Environment.getBaseUrl() + "/deals/8105"));
            case "cat deals":
                driver.navigate().to(Environment.getBaseUrl() + "/deals/cat-deals-2735");
                break;
            case "dog food":
                driver.navigate().to(Environment.getBaseUrl() + "/deals/dog-deals-2733");
                break;
            default:
                break;
        }
        //TODO address the fact that non-prod and prod deals pages are not in sync
        //DealsPage dealsPage = new DealsPage(driver);
        //dealsPage.clickDeal(deal);
    }
}
