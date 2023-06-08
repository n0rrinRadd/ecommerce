package com.ecommerce.pages.storefront.common;

import com.ecommerce.pages.storefront.base.BasePage;
import com.ecommerce.pages.storefront.discovery.header.Sort;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchField extends BasePage {

    private final WebDriver driver;
    private WebDriverWait wait;

    public SearchField(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 100);
    }

    @FindBy(id = "search-autocomplete")
    public WebElement searchForm;

    @FindBy(className = "sfw-search__submit")
    public WebElement searchButton;

    @FindBy(css = "#search__suggestions li")
    public List<WebElement> searchSuggestionListItems;

    public String SearchFor(String searchTerm){
        clear(searchForm);
        sendKeys(searchForm, searchTerm.replaceAll("^\"|\"$", ""));
        if (System.getProperty("browserView").contains("mobile")){
            submit(searchForm);
        }
        else {
            click(searchButton);
        }
        Sort sort = new Sort(driver);
        wait.until(ExpectedConditions.visibilityOf(sort.selector));
        return driver.getCurrentUrl();
    }

    public void selectSearchSuggestion(String suggestion) {
        clear(searchForm);
        sendKeys(searchForm, " ");
        for(WebElement listItems : searchSuggestionListItems){
            if(listItems.getText().equals(suggestion)) {
                click(listItems);
                break;
            }
        }
    }

    public void searchFor(String appendedUrl){
        driver.navigate().to(getBaseUrl() + appendedUrl);
    }
}
