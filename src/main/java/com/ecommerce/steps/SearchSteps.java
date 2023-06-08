package com.ecommerce.steps;

import com.ecommerce.helpers.Environment;
import com.ecommerce.pages.storefront.common.SearchField;
import com.ecommerce.pages.storefront.discovery.SearchPage;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;


public class SearchSteps {

    WebDriver driver;
    Environment environment;
    private BaseDriver baseDriver;

    public SearchSteps(BaseDriver baseDriver) {
        this.baseDriver = baseDriver;
        this.driver = baseDriver.getDriver();
        this.environment = new Environment();
    }

    @When("I type {} in the search bar and click submit")
    public void i_type_x_in_the_search_bar_and_click_submit(String arg1) {
        SearchField navigation = new SearchField(driver);
        navigation.SearchFor(arg1);
    }

    @When("I search by keyword for {}")
    public void i_search_by_keyword_x(String arg1) {
        SearchPage navigation = new SearchPage(driver);
        navigation.searchForByUrl(arg1);
    }

    @When("I search for the {} priced {}")
    public void i_search_for_x_by_sort_y(String x, String y) {
        SearchPage navigation = new SearchPage(driver);
        if (x.contains("lowest") || x.contains("highest")) {
            navigation.searchForByUrlSortBy(y, x + "Price");
        } else {
            throw new IllegalStateException(y + " is not a supported price sort option");
        }
    }

    @When("I search and select {string} from the suggestion list")
    public void i_search_for_and_select_from_the_suggestion_list(String arg1) {
        SearchField navigation = new SearchField(driver);
        navigation.selectSearchSuggestion(arg1);
    }
}
