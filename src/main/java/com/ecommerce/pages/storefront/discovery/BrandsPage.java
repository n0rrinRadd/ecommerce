package com.ecommerce.pages.storefront.discovery;

import com.ecommerce.pages.storefront.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BrandsPage extends BasePage {

    private final WebDriver driver;
    private WebDriverWait wait;

    public BrandsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 100);
    }

    @FindAll({
            @FindBy(css = ".brands-list a"),
            @FindBy(css = "section a")
    })
    private List<WebElement> brandLinks;

    public WebElement getBrandByName(String brandName){
        for (WebElement brandLink : brandLinks) {
            if (brandLink.getText().contains(brandName)){
                return brandLink;
            }
        }
        return null;
    }


    public void goTo(String brand){
        goTo("/" + brand);
    }

    public WebElement getBrandByIndex(int index){
        return brandLinks.get(index);
    }

    public void clickBrandLink() {
        clickBrandLinkByIndex(0);
    }

    public void clickBrandLinkByIndex(int index) {
        click(brandLinks.get(index));
        ResultsPage resultsPage = new ResultsPage(driver);
        wait.until(ExpectedConditions.visibilityOf(resultsPage.resultsTitle));
    }

    public void clickBrandByName(String name){
        click(getBrandByName(name));
        ResultsPage resultsPage = new ResultsPage(driver);
        wait.until(ExpectedConditions.visibilityOf(resultsPage.resultsTitle));
    }

    public void gotToBrandByName(String name){
        String href = getBrandByName(name).getAttribute("href");
        driver.navigate().to(href);
        ResultsPage resultsPage = new ResultsPage(driver);
        wait.until(ExpectedConditions.visibilityOf(resultsPage.resultsTitle));
    }
}
