package com.ecommerce.pages.storefront.discovery.header;

import com.ecommerce.pages.storefront.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BreadCrumbs extends BasePage {

    private final WebDriver driver;

    public BreadCrumbs(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindAll({
            @FindBy(css = ".cw-breadcrumb"),
            @FindBy(css = ".breadcrumbs")
    })
    private WebElement div;

    public List<WebElement> getBreadCrumbsList(){
        try{
            return div.findElements(By.tagName("li"));
        }
        catch (Exception ex){
        }
        return driver.findElements(By.cssSelector("p.search-details"));
    }

    public void clickBreadCrumb(WebElement element, String expectedUrl){
        String preUrl = driver.getCurrentUrl();
        click(element);
        wait.until(ExpectedConditions.not(ExpectedConditions.urlContains(preUrl)));
    }

    public WebElement getBreadCrumbByIndex(Integer index){
        return getBreadCrumbsList().get(index);
    }

    public WebElement getBreadCrumbByName(String name){
        for (WebElement breadcrumb : getBreadCrumbsList()){
            if (breadcrumb.getText().toLowerCase().contains(name.toLowerCase())) return breadcrumb;
        }
        return null;
    }

    public void clickBreadCrumbByIndex(Integer index){
        String preUrl = driver.getCurrentUrl();
        click(getBreadCrumbByIndex(index));
        wait.until(ExpectedConditions.not(ExpectedConditions.urlContains(preUrl)));
    }

    public void clickBreadCrumbByName(String name){
        click(getBreadCrumbByName(name));
    }
}