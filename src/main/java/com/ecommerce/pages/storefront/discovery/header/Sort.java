package com.ecommerce.pages.storefront.discovery.header;

import com.ecommerce.pages.storefront.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Sort extends BasePage {

    private final WebDriver driver;
    private WebDriverWait wait;

    public Sort(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 100);
    }

    @FindAll({
            @FindBy(css = ".search-results-sort"),
            @FindBy(css = ".btn-search-sort"),
            @FindBy(id = "searchSortForm")
    })
    public WebElement button;

    @FindAll({
            @FindBy(name = "sort"),
            @FindBy(css = ".btn-search-sort"),
            @FindBy(css = "button.cw-btn--sort-dialog")
    })
    public WebElement selector;

    @FindBy(id = "searchSortForm")
    public WebElement searchSortForm;

    @FindBy(css = "a.cw-text__color--text-body")
    public List<WebElement> sortByOptions;

    public void selectSortOptionByText(String text) {
        if (System.getProperty("browserView", "desktop").contains("mobile")){
            click(selector);
            for (WebElement sortByOption : sortByOptions){
                if (sortByOption.getText().contains(text)){
                    click(sortByOption);
                }
            }
        }
        else {
            Select select = new Select(selector);
            select.selectByVisibleText(text);
        }
    }

    public void selectSortOption(SortByTypes sortByType){
        String locator = null;
        switch (sortByType){
            case RELEVANCE:
                locator = "relevance";
                break;
            case NEWEST:
                locator = "newest";
                break;
            case PRICELOWTOHIGH:
                locator = "lowestPrice";
                break;
            case PRICEHIGHTOLOW:
                locator = "highestPrice";
                break;
            case AVGCUSTOMERREVIEWS:
                locator = "rating";
                break;
            case MOSTREVIEWS:
                locator = "ratingCount";
                break;
            default:
                break;
        }
        Select select = new Select(selector);
        select.selectByValue(locator);
    }
}