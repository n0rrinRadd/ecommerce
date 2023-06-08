package com.ecommerce.pages.storefront.product;

import com.ecommerce.pages.storefront.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailPage extends BasePage {


    private final WebDriver driver;
    private WebDriverWait wait;

    public ProductDetailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 100);
    }

    @FindAll({
            @FindBy(css = ".in-stock"),
            @FindBy(css = ".out-of-stock"),
    })
    public WebElement availabilityStatus;


    public boolean productIsAvailable() {
        if (availabilityStatus.getText().equals("In stock")) {
            return true;
        }
        return false;
    }
}