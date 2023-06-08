package com.ecommerce.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static java.lang.Thread.sleep;

public class WebUtils {

    protected final WebDriver driver;

    public WebUtils(WebDriver driver) {
        this.driver = driver;
    }

    public JavascriptExecutor jsExe() {
        return (JavascriptExecutor) driver;
    }

    public void scrollToElement(WebElement element) {
        try{
            Actions actions = new Actions(driver);
            actions.moveToElement(element);
            actions.perform();
        }
        catch (Exception ex){
            System.out.println("Was not able to perform actions.MoveToElement, attempting javascript scroll into view");
        }
        finally {
            jsExe().executeScript("arguments[0].scrollIntoView(true);"
                    + "window.scrollBy(0,-100);", element);
            try {
                sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
