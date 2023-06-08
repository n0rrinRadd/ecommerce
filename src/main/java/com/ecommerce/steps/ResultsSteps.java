package com.ecommerce.steps;

import com.ecommerce.helpers.Environment;
import com.ecommerce.pages.storefront.discovery.ResultsPage;
import com.ecommerce.pages.storefront.discovery.header.BreadCrumbs;
import com.ecommerce.pages.storefront.discovery.header.Categories;
import com.ecommerce.pages.storefront.discovery.header.Sort;
import com.ecommerce.pages.storefront.discovery.header.SortByTypes;
import com.ecommerce.pages.storefront.product.ProductDetailPage;
import com.ecommerce.utils.Convert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.ecommerce.pages.storefront.discovery.header.SortByTypes.PRICEHIGHTOLOW;
import static com.ecommerce.pages.storefront.discovery.header.SortByTypes.PRICELOWTOHIGH;
import static org.testng.Assert.assertTrue;

public class ResultsSteps {

    WebDriver driver;
    ResultsPage resultsPage;
    SoftAssertions softly;
    Environment environment;

    private BaseDriver baseDriver;

    public ResultsSteps(BaseDriver baseDriver) {
        this.baseDriver = baseDriver;
        this.driver = baseDriver.getDriver();
        this.softly = new SoftAssertions();
        this.resultsPage = new ResultsPage(driver);
        this.environment = new Environment();
    }

    @Then("I see {string} display in results page title")
    public void i_see_search_query_display_in_results_page_title(String arg1) throws Throwable {
        ResultsPage resultsPage = new ResultsPage(driver);
        String searchResultsCategoryTitle = resultsPage.getSearchResultsTitle();
        softly.assertThat(searchResultsCategoryTitle.toLowerCase()).contains(arg1);
        driver.quit();
        softly.assertAll();
    }

    @Then("the url contains {string}")
    public void the_url_contains(String arg1){
        String currentUrl = resultsPage.getUrl();
        assertTrue(currentUrl.contains(arg1), "The keyword search url:" + currentUrl+ " was missing " + arg1);
    }

    @Then("I should not see the message {string} on the {string} tiles")
    public void i_should_not_see_the_message_x_on_the_y_tiles(String x, String y){
        SoftAssertions softly = new SoftAssertions();
        for(WebElement tile : resultsPage.tiles){
            WebElement content = tile.findElement(By.className("content"));
            if (content.getText().contains(y)){
                softly.assertThat(content.getText()).doesNotContain(x);
            }
        }
        softly.assertAll();
    }

    @And("the price is {} ${string}")
    public void the_price_is_over_under_x(String over_under, String x){
        SortByTypes sortByType = null;
        Sort sort = new Sort(driver);
        if (over_under.toLowerCase().contains("under")) sortByType = PRICELOWTOHIGH;
        else if (over_under.toLowerCase().contains("over")) sortByType = PRICEHIGHTOLOW;
        if (System.getProperty("browserView").contains("mobile")) sort.selectSortOption(sortByType);
        else sort.selectValue(sort.selector, sortByType.getSortBy());
    }

    @Then("I see the configured shipping {} on the product tile")
    public void i_see_the_configured_free_shipping_message_on_the_product_tile(String message) {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(resultsPage.tiles.get(0).getText()).contains(message);
        softly.assertAll();
    }

    @Then("I see the following shipping {} on the product tile")
    public void I_see_the_configured_shipping_on_the_product_tile(String message) {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(resultsPage.tiles.get(0).getText()).contains(message);
        softly.assertAll();
    }

    @And("I sort by {string}")
    public void i_sort_by_type(String sortType) throws InterruptedException {
        Sort sort = new Sort(driver);
        sort.selectSortOptionByText(sortType);
    }

    @When("I click on the l1 category {}")
    public void i_click_on_the_l1_category(String subCategory){
        Categories categories = new Categories(driver);
        categories.clickCategoryByName(subCategory);
    }

    @When("I click on the l2 category {}")
    public void i_click_on_the_l2_category(String subCategory){
        Categories categories = new Categories(driver);
        categories.clickCategoryByName(subCategory);
        try{
            Thread.sleep(1000);
        }
        catch (Exception ex) {}
    }

    @When("I click on the l2 {} category {}")
    public void i_click_on_the_sub_category(String category, String subCategory){
        Categories categories = new Categories(driver);
        categories.clickCategoryByName(category, subCategory);
    }

    @When("I click on the pagination {} button")
    public void i_click_on_pagination_button(String buttonName) {
        ResultsPage resultsPage = new ResultsPage(driver);
        switch(buttonName) {
            case "next page":
                resultsPage.click(resultsPage.nextButton);
                break;
            case "previous page":
                resultsPage.click(resultsPage.previousButton);
                break;
        }
    }

    @Then("{} displays in the breadcrumbs")
    public void category_displays_in_the_breadcrumbs(String category){
        BreadCrumbs breadCrumbs = new BreadCrumbs(driver);
        try {
            Thread.sleep(1000);
        }
        catch (Exception ex) {}
        softly.assertThat(breadCrumbs.getBreadCrumbByName(category)).isNotNull();
        softly.assertAll();
    }

    @And("{} displays in the results header")
    public void category_displays_in_the_results_header(String category) {
        if (System.getProperty("browserView").contains("desktop")) {
            ResultsPage resultsPage = new ResultsPage(driver);
            List<String> inputStringList = Convert.stringToList(resultsPage.getSearchResultsTitle());
            List<String> wordsList = Convert.stringToList(category);
            softly.assertThat(inputStringList.containsAll(wordsList));
            softly.assertAll();
        }
    }

    @And("the results header displays")
    public void the_results_header_displays() {
        ResultsPage resultsPage = new ResultsPage(driver);
        softly.assertThat(resultsPage.resultsTitle.isDisplayed());
        softly.assertAll();
    }

    @And("the product tiles contain {} in the description")
    public void the_product_tile_contain_category_in_the_description(String category){
        ResultsPage resultsPage = new ResultsPage(driver);
        softly.assertThat(resultsPage.productTilesContainText(category));
        softly.assertAll();
    }

    @And("at least one product tile displays")
    public void at_least_one_product_tile_displays(){
        ResultsPage resultsPage = new ResultsPage(driver);
        softly.assertThat(resultsPage.tiles.get(0).isDisplayed());
        softly.assertAll();
    }

    @And("{int} product tiles display")
    public void expected_number_of_product_tiles_display(int numTiles){
        ResultsPage resultsPage = new ResultsPage(driver);
        int numSearchResults = resultsPage.searchResultTiles.size();
        softly.assertThat(numSearchResults).isEqualTo(numTiles);
        for(int i = 0; i < numTiles && i < numSearchResults; i++) {
            softly.assertThat(resultsPage.tiles.get(i).isDisplayed());
        }
        softly.assertAll();
    }


    @Then("only {} brand results display")
    public void only_x_brand_results_display(String brand){
        ResultsPage resultsPage = new ResultsPage(driver);
        //TODO this should be an document response check via http, runs too slow when calling allProductTilesContainText
        softly.assertThat(resultsPage.productTileTitleContainText(brand, 0));
        softly.assertAll();
    }

    @Then("only {} brand facet results display")
    public void only_x_brand_facet_results_display(String brand_facet){
        only_x_brand_results_display(brand_facet);
    }

    @Then("the css {} displays")
    public void the_css(String selector){
        softly.assertThat(driver.findElement(By.cssSelector(selector)).isDisplayed());
        softly.assertAll();
    }

    @Then("the banner displays in slot {}")
    public void the_banner_displays_in_slot(String x){
        softly.assertThat(resultsPage.banner.getAttribute("data-placement-slot-number")).contains(x);
    }

    @And("the cms fragment displays in slot {}")
    public void the_cms_fragment_displays_in_slot(String x){
        softly.assertThat(resultsPage.cmsFragmentSlot(x).isDisplayed());
        softly.assertAll();
    }

    @Then("the top {} items are not out of stock {} search results")
    public void the_top_x_items_are_not_out_of_stock(int x, String query) {
        ResultsPage resultsPage = new ResultsPage(driver);
        for (int i = 0; i < x; i++) {
            resultsPage.click(resultsPage.tileTitles.get(i));
            ProductDetailPage pdPage = new ProductDetailPage(driver);
            int num = i+1;
            softly.assertThat(pdPage.productIsAvailable()).withFailMessage("query:" + query + ", product tile number:" + num + " was out of stock").isTrue();
            driver.navigate().back();
        }
        softly.assertAll();
    }

    @Then("the page navigates to {}")
    public void the_page_navigates_to_x(String url){
        String currentUrl = driver.getCurrentUrl();
        softly.assertThat(currentUrl.contains(url));
        softly.assertAll();
    }
}
