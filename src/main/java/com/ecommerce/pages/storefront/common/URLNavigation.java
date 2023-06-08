package com.ecommerce.pages.storefront.common;

import com.ecommerce.pages.storefront.helpers.Categories;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class URLNavigation{

    private final WebDriver driver;
    private WebDriverWait wait;

    public URLNavigation(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

   public void ToCategory(String env, Categories category){
        String href = "";
        switch (category){
            case SMALL_PET:
                href = "b/item-number";
                break;
            case HORSE:
                href = "b/horse-1663";
                break;
            case TODAYS_DEALS:
                href = "app/content/abc-123";
                break;
            default:
                break;
        }
        driver.navigate().to(env + href);
   }
}
