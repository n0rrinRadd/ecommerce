package com.ecommerce.steps;

import com.ecommerce.pages.storefront.discovery.header.Filter;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FilterSteps {

    WebDriver driver;
    Filter filter;
    SoftAssertions softly;
    WebDriver wait;

    private BaseDriver baseDriver;

    public FilterSteps(BaseDriver baseDriver) {
        this.baseDriver = baseDriver;
        this.driver = baseDriver.getDriver();
        this.softly = new SoftAssertions();
    }
    @And("I click the {} filter {}")
    public void i_click_on_the_facet(String categoryName, String filterName){
        filter = new Filter(driver);
        filter.clickFacetCategoryFilter(categoryName, filterName);
    }

    @When("I click the filter region index {int}")
    public void i_click_the_filter_region_index(int index){
        filter.clickFilterRegionByIndex(index);
    }

    @Then("the facet category name contains {int}")
    public void the_facet_category_name_contains(int index){
        softly.assertThat(filter.facetCategoryNames.get(2).findElement(By.tagName("h3")).getText()).contains("(" + index + ")");
        softly.assertAll();
    }

}
