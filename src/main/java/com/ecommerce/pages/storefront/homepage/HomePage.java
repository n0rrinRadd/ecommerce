package com.ecommerce.pages.storefront.homepage;

import com.ecommerce.pages.storefront.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class HomePage extends BasePage {

    private final WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 100);
    }

    @FindBy(xpath = "//nav[@class='sub-nav']")
    WebElement navigationDiv;

    /**
     * <p>Waits for the navigation bar to load from the home page.  This
     * best use case is for returning from the Login Page.</p>
     * @return True if the Nav Bar appeared before the time out.
     */
    public boolean isNavVisible() {
        wait.until(elementToBeClickable(navigationDiv));
        return true;
    }
}