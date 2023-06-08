package com.ecommerce.pages.storefront.discovery.header;

import com.ecommerce.pages.storefront.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Facets extends BasePage {

    public WebDriverWait wait;

    @FindAll({
        @FindBy(css = ".pill"),
        @FindBy(css = ".cw-pill"),
        //@FindBy(css = ".search-filters p a")
    })
    public List<WebElement> facets;

    @FindAll({
            @FindBy(css = "div.search-results-facets > a"),
            @FindBy(className = "facet-clear")
    })
    public WebElement clearAllLink;

    @FindAll({
        @FindBy(css = "span.facet-buttons > button"),
        @FindBy(className = "cw-btn--plus-more")
    })
    public WebElement plusMoreButton;

    @FindBy(className = "cw-pill__control")
    public List<WebElement> xButton;

    @FindBy(css = "#filter-refinement__brand_facet li a")
    private List<WebElement> brandFacetList;

    @FindBy(className = "filter-section")
    public List<WebElement> filterSections;

    private final WebDriver driver;

    public Facets(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 100);
    }

    public WebElement getFacetsByName(String facetName) {
        int match = 0;
        String[] words = facetName.split(" ");
        for (WebElement facet : facets){
            for (String word : words){
                if (facet.getText().toLowerCase().contains(word.toLowerCase())) match++;
            }
            if (match==words.length) return facet;
            else match = 0;
        }
        return null;
    }

    public void RemoveFacet() {
        RemoveFacetByIndex(0);
    }

    public void RemoveFacetByIndex(int index) {
        xButton.get(index).click();
    }

    public void clickFilterValueInFilterSection(Integer filterValueIndex, String filterSectionName) {
        for (WebElement filterSection : filterSections){
            String h3 = "";
            try{
                h3 = filterSection.findElement(By.tagName("h3")).getText();
            }
            catch (Exception ex){ }
            if (h3.toLowerCase().contains(filterSectionName.toLowerCase())){
                try{
                    List<WebElement> facets = filterSection.findElements(By.cssSelector("ul li a"));
                    click(facets.get(filterValueIndex));
                }
                catch (Exception ex){ }
                break;
            }
        }
        wait.until(ExpectedConditions.urlContains("brand_facet"));
    }

    // "getFacetsByName" requires facets with class .pill to be included to work properly
    // Somehow, .pill and .cw-pill (sometimes??) duplicates one of the facet selections, leading to an inaccurate facet count on mobile
    // By taking only the selections with class .cw-pill, we can accurately count the number of selected facets
    public int getNumFacetsSelected() {
        int count = 0;
        for(WebElement facet : facets) {
            if(facet.getAttribute("class").contains("cw-pill")) count++;
        }
        return count;
    }
}