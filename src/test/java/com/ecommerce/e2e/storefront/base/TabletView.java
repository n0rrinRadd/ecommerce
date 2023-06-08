package com.ecommerce.e2e.storefront.base;

import com.ecommerce.AbstractTest;
import com.ecommerce.helpers.Environment;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public abstract class TabletView extends AbstractTest {

    public WebDriver driver;

    @BeforeMethod(alwaysRun=true)
    public void BeforeMethod(Method m){
        System.setProperty("browserView", "tablet");
        System.setProperty("browserMode", "gui");
        driver = startWebDriver(m.getName());
        driver.navigate().to(Environment.getStorefrontBaseUrl());
    }

    @AfterMethod(alwaysRun = true)
    public void After(){
        driver.quit();
    }
}