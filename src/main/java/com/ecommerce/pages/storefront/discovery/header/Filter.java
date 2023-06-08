package com.ecommerce.pages.storefront.discovery.header;

import com.ecommerce.pages.storefront.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class Filter extends BasePage {

    public Filter(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindAll({
        @FindBy(css = ".search-results-filter"),
        @FindBy(css = ".btn-search-filter")
    })
    public WebElement button;

    @FindBy(css = ".cw-accordion.filter-list")
    public WebElement filterList;

    @FindBy(css = "#cw-accordion-1 dt")
    public List<WebElement> filters;

    @FindAll({
        @FindBy(css = "dt[role=heading]"),
        @FindBy(css = ".filter-section")
    })
    public List<WebElement> facetCategoryNames;

    @FindAll({
            @FindBy(css = "dd[role=region]"),
            @FindBy(css = ".vue-portal-target .filter-section li")
    })
    public List<WebElement> facetFilters;

    @FindBy(css = ".filter-section .filter-categories .js-tracked-facet")
    public WebElement categoryHeadings;

    @FindAll({
            @FindBy(css = "section.is-visible button"),
            @FindBy(css = ".cw-drawer__close")
    })
    public List<WebElement> backToResultsButtons;


    public WebElement backToResultsButton;
    @FindBy(css= ".see-more-btn")
    public List<WebElement> seeMoreButton;

    @FindAll({
            @FindBy(className = "accordion-item"),
    })
    public List<WebElement> accordianItems;

    public WebElement seeMoreButton(){
        return seeMoreButton(0);
    }

    public WebElement seeMoreButton(int index){
        return seeMoreButton.get(index);
    }

    public void clickSeeMoreButton(){
        click(seeMoreButton());
    }

    public void clickFilter(String name, String filter){
        for(WebElement accordianItem : accordianItems){
            WebElement accordianTrigger = accordianItem.findElement(By.tagName("span"));
            if (accordianTrigger.getText().toLowerCase().contains(name)){
                if (!accordianTrigger.getAttribute("class").contains("is-accordion-open")){
                    click(accordianTrigger);
                }

                List<WebElement> accordianListItems = driver.findElements(By.cssSelector("div ul li"));
                for(WebElement accordianListItem : accordianListItems){
                    if (accordianListItem.getText().toLowerCase().contains(filter)){
                        click(accordianListItem.findElement(By.tagName("a")));
                    }
                }
            }
        }
    }



    public void clickFilterButton(){
        button.click();
        if (System.getProperty("browserView").contains("mobile")) clickFirstFilterHeading();
    }

    public void clickFirstFilterHeading(){
        clickFilterHeadingByIndex(0);
    }

    public void clickFilterHeadingByIndex(int index){
        click(facetCategoryNames.get(index));
    }

    public void clickFirstFilterRegion(){
        clickFilterRegionByIndex(0);
    }

    public String clickFilterRegionByIndex(int index){
        wait.until(ExpectedConditions.visibilityOf(facetCategoryNames.get(2)));
        String filterRegionText = "";
        if (System.getProperty("browserView").contains("desktop")) {
            WebElement label = facetFilters.get(index).findElement(By.cssSelector("label"));
            filterRegionText = label.getText();
            new Actions(driver).moveToElement(label, 1, 1).click().perform();
        }
        else{
            WebElement element = facetFilters.get(index).findElement(By.cssSelector(".facet"));
            filterRegionText = element.getText();
            click(element);
        }
        return filterRegionText.split("\n")[0];
    }

    public void clickBackToResultsButton() {
        backToResultsButton = backToResultsButtons.get(1);
        click(backToResultsButton);
        wait.until(ExpectedConditions.invisibilityOf(backToResultsButton));
        wait.until(ExpectedConditions.visibilityOf(button));
    }

    public void clickFirstFilterOption(){
        if (System.getProperty("browserView").contains("mobile")) {
            clickFilterButton();
        }
        clickFirstFilterRegion();
    }

    public WebElement getFilterHeadingByName(String name){
        WebElement h3 = null;
        for (WebElement filterHeading : facetCategoryNames){
            h3 = null;
            try{
                h3 = filterHeading.findElement(By.tagName("h3"));
                if (h3.getText().toLowerCase().contains(name)){
                    return filterHeading;
                }
            }
            catch (Exception ex){}
        }
        return null;
    }

    public WebElement getFilterContent(String filterHeadingName, String filterContentName){
        WebElement filterHeading = getFilterHeadingByName(filterHeadingName);
        List<WebElement> filterContents = filterHeading.findElements(By.cssSelector(".filter-content ul li"));
        for (WebElement filterContent : filterContents){
            if (filterContent.getText().toLowerCase().contains(filterContentName.toLowerCase())) {
                return filterContent;
            }
        }
        return null;
    }

    public WebElement getFacetCategory(String name){

        return driver.findElement(By.cssSelector("*[data-facet-category="+ toTitleCase(name) +"]"));
    }

    public List<WebElement> getFacetCategoryFilters(String name){
        String locator = "*[data-facet-category=\""+ toTitleCase(name) +"\"]";
        return driver.findElements(By.cssSelector(locator + " ul li"));
    }

    public WebElement getFacetCategoryFilter(String categoryName, String filterName){
        for (WebElement categoryFilter : getFacetCategoryFilters(categoryName)){
            if (categoryFilter.getText().toLowerCase().contains(filterName.toLowerCase())) {
                return categoryFilter;
            }
        }
        return null;
    }

    public void clickFacetCategoryFilter(String categoryName, String filterName){
        WebElement fetch = getFacetCategoryFilter(categoryName, filterName);
        try{
            WebElement element = fetch.findElement(By.tagName("a"));
            click(element);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,350)", "");
            js.executeScript("window.scrollBy(0,-350)", "");
        }
        catch (Exception ex) {
            click(fetch);

        }
    }

    public static String toTitleCase(String input) {
        input = input.toLowerCase();
        StringBuilder titleCase = new StringBuilder(input.length());
        boolean nextTitleCase = true;

        for (char c : input.toCharArray()) {
            if (Character.isSpaceChar(c)) {
                nextTitleCase = true;
            } else if (nextTitleCase) {
                c = Character.toTitleCase(c);
                nextTitleCase = false;
            }

            titleCase.append(c);
        }

        return titleCase.toString();
    }

}