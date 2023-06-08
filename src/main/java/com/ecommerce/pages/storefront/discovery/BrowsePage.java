package com.ecommerce.pages.storefront.discovery;

import com.ecommerce.pages.storefront.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BrowsePage extends BasePage {

    private final WebDriver driver;
    private WebDriverWait wait;

    public BrowsePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 100);
    }

    public void goTo(String url){
        goTo("/b/" + url);
    }

    @FindAll({
            @FindBy(css = ".cms-content")
    })
    public WebElement cmsContent;

    @FindAll({
            @FindBy(css = ".cms-content .depart-page")
    })
    public WebElement cmsContentDepartmentPage;

    @FindAll({
            @FindBy(css = ".cms-content .depart-page section"),
            @FindBy(css = ".depart-page .dotcms-include")
    })
    public List<WebElement> cmsContentDepartmentPageSections;
}
