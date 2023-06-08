package com.ecommerce.pages.storefront.discovery;

import com.ecommerce.pages.storefront.base.BasePage;
import com.ecommerce.pages.storefront.common.SearchField;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends BasePage {

    private final WebDriver driver;
    private WebDriverWait wait;

    public SearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 100);
    }

    public void goTo(String url){
        goTo("/s/" + url);
    }

    public String searchForByUrl(String searchTerm){
        SearchField searchField = new SearchField(driver);
        searchField.searchFor("/s?query=" + searchTerm + "&nav-submit-button=");
        ResultsPage resultsPage = new ResultsPage(driver);
        //TODO remove comment below when https://ecommerce.slack.com/archives/GP5SLFRV3/p1588807447057600 is resolved
        //wait.until(ExpectedConditions.visibilityOfAllElements(resultsPage.tiles));
        return driver.getCurrentUrl();
    }

    public String searchForByUrlSortBy(String searchTerm, String sortBy){
        SearchField searchField = new SearchField(driver);
        searchField.searchFor( "/s?query=" + searchTerm + "&sort=" + sortBy);
        try{
            Thread.sleep(1000);
        }
        catch (Exception ex) {}
        ResultsPage resultsPage = new ResultsPage(driver);
        //TODO remove comment below when https://ecommerce.slack.com/archives/GP5SLFRV3/p1588807447057600 is resolved
        //wait.until(ExpectedConditions.visibilityOf(resultsPage.resultsTitle));
        return driver.getCurrentUrl();
    }
}
