package com.ecommerce.pages.storefront.discovery;

import com.ecommerce.pages.storefront.base.BasePage;
import com.ecommerce.utils.WebUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DealsPage extends BasePage {

    private final WebDriver driver;
    private WebDriverWait wait;

    public DealsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 100);
    }

    @FindAll({
            @FindBy(css = ".cw-carousel__slide")
    })
    public List<WebElement> carouselElements;

    public WebElement getDealButton(String deal){
        for (WebElement dealElement : carouselElements){
            if (dealElement.findElement(By.cssSelector(".cw-row__item__content")).getText().toLowerCase().contains(deal)){
                return dealElement;
            }
        }
        return null;
    }

    public void goTo(String url){
        goTo("/deals/" + url);
    }

    public void clickDeal(String deal){
        WebElement button = getDealButton(deal);
        WebUtils webUtils = new WebUtils(driver);
        webUtils.scrollToElement(button);
        click(button);
        ResultsPage resultsPage = new ResultsPage(driver);
        wait.until(ExpectedConditions.visibilityOf(resultsPage.resultsTitle));
    }
}
