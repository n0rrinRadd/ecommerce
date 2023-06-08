package com.ecommerce.steps;

import com.ecommerce.pages.storefront.base.BasePage;
import com.ecommerce.pages.storefront.discovery.BrandsPage;
import com.ecommerce.pages.storefront.homepage.HomePage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class NavigationSteps {

    WebDriver driver;
    BasePage basePage;

    private BaseDriver baseDriver;

    public NavigationSteps(BaseDriver baseDriver) {
        this.baseDriver = baseDriver;
        this.driver = baseDriver.getDriver();
    }

    @When("I navigate to the url {}")
    public void i_navigate_to_the_url(String url) throws PendingException {
        basePage = new HomePage(driver);
        basePage.goTo();
        basePage.goTo(url);
    }

    @When("I navigate to the {} page")
    public void i_navigate_to_the_page(String page) throws PendingException {
        BasePage basePage = new BasePage(driver);
        switch (page){
            case "brands":
                basePage.goTo("/brands");
                break;
            case "pharmacy":
                i_navigate_to_the_shop_by_pet_page(page);
            case "deals":
                basePage.goTo("/app/content/abc-123");
                break;
            default:
                break;
        }
    }

    @Given("I navigate to the shop by pet {} page")
    public void i_navigate_to_the_shop_by_pet_page(String pet) throws PendingException {
        BasePage basePage = new BasePage(driver);
        switch (pet) {
            case "dog":
                basePage.goTo("/b/brand-288");
                break;
            case "cat":
                basePage.goTo("/b/brand-325");
                break;
            case "fish":
                basePage.goTo("/b/brand-885");
                break;
            case "bird":
                basePage.goTo("/b/brand-941");
                break;
            case "small pet":
                basePage.goTo("/b/item-number");
                break;
            case "reptile":
                basePage.goTo("/b/brand-1025");
                break;
            case "horse":
                basePage.goTo("/b/brand-1663");
                break;
            case "pharmacy":
                basePage.goTo("/b/brand-2515");
                break;
            default:
                break;
        }
    }

    @And("I navigate to brand {}")
    public void i_navigate_to_brand(String brandName){
        BrandsPage brandsPage = new BrandsPage(driver);
        driver.navigate().to(brandsPage.getBrandByName(brandName).getAttribute("href"));
    }
}