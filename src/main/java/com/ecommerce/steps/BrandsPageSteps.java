package com.ecommerce.steps;

import com.ecommerce.pages.storefront.discovery.BrandsPage;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;

public class BrandsPageSteps {

    WebDriver driver;

    private BaseDriver baseDriver;

    public BrandsPageSteps(BaseDriver baseDriver) {
        this.baseDriver = baseDriver;
        this.driver = baseDriver.getDriver();
    }

    @And("I click on a brand")
    public void i_click_on_a_brand(String brand) {
        BrandsPage brandsPage = new BrandsPage(driver);
        brandsPage.clickBrandLink();
    }

    @And("I click on brand # {int}")
    public void i_click_the_brand_number(int number){
        BrandsPage brandsPage = new BrandsPage(driver);
        brandsPage.clickBrandLinkByIndex(number-1);
    }

    @And("I navigate to brand # {int}")
    public void i_navigate_to_brand_number(int number){
        BrandsPage brandsPage = new BrandsPage(driver);
        driver.navigate().to(brandsPage.getBrandByIndex(number-1).getAttribute("href"));
    }

    @And("I click on brand {}")
    public void i_click_the_brand(String brandName){
        BrandsPage brandsPage = new BrandsPage(driver);
        brandsPage.clickBrandByName(brandName);
    }


}
