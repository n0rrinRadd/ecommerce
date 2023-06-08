package com.ecommerce.pages.landing;

import com.ecommerce.pages.storefront.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CampaginPage extends BasePage {

    private final WebDriver driver;
    private WebDriverWait wait;

    public CampaginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 100);
    }

    public void goTo(String url){
        goTo("/app/content/" + url);
    }

}
