package com.ecommerce.steps;

import com.ecommerce.pages.storefront.discovery.BrowsePage;
import io.cucumber.java.en.Then;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;

public class BrowseSteps {

    WebDriver driver;
    SoftAssertions softly;

    private BaseDriver baseDriver;

    public BrowseSteps(BaseDriver baseDriver) {
        this.baseDriver = baseDriver;
        this.softly = new SoftAssertions();
        this.driver = baseDriver.getDriver();
    }

    @Then("the department page contains sections")
    public void the_department_page_contains_sections() {
        BrowsePage browsePage = new BrowsePage(driver);
        softly.assertThat(browsePage.cmsContentDepartmentPageSections).size().isGreaterThan(0);
        softly.assertAll();
    }
}