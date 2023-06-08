package com.ecommerce.pages.storefront.category;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Category {

    private final WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "header[class='products-header']>a")
    public WebElement shopAllLink;

    public Category(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
