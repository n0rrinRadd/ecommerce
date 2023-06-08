package com.ecommerce.steps;

import com.ecommerce.pages.storefront.discovery.header.Filter;
import com.ecommerce.pages.storefront.discovery.header.Sort;
import io.cucumber.java.en.And;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;

public class SortSteps {

    WebDriver driver;
    Filter filter;
    SoftAssertions softly;

    private BaseDriver baseDriver;

    public SortSteps(BaseDriver baseDriver) {
        this.baseDriver = baseDriver;
        this.driver = baseDriver.getDriver();
        this.softly = new SoftAssertions();
    }
    @And("I click on a sorting {}")
    public void i_click_on_sorting(String option) {
        Sort sort = new Sort(driver);
        sort.selectSortOptionByText(option);
    }
}
