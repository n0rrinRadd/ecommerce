package com.ecommerce.pages.storefront.discovery;

import com.ecommerce.pages.storefront.base.BasePage;
import com.ecommerce.utils.Convert;
import com.ecommerce.utils.WebUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ResultsPage extends BasePage {

    private final WebDriver driver;
    private WebDriverWait wait;

    public ResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 100);
    }

    @FindAll({
            @FindBy(css = ".results-cat-title"),
            @FindBy(css = ".search-results-title"),
            @FindBy(css = ".sfw-plp-search-results--header--title"),
    })
    public WebElement resultsTitle;

    @FindBy(css = ".js-tracked-product")
    public List<WebElement> tiles;

    @FindAll({
            @FindBy(css = ".search-item"),
            @FindBy(css = ".product-holder"),
            @FindBy(css = ".kib-row__item")
    })
    public List<WebElement> searchResultTiles;

    @FindBy(css = ".cw-pagination__previous")
    public WebElement previousButton;

    @FindBy(css = ".cw-pagination__next")
    public WebElement nextButton;

    @FindAll({
            @FindBy(css = ".js-tracked-product h2 strong"),
            @FindBy(css = ".js-tracked-product h3 strong")
    })
    public List<WebElement> tileTitles;

    @FindBy(css = ".cms-promo-banner")
    public WebElement banner;

    public WebElement cmsFragmentSlot(String slotNumber){
        String cmsFragment = ".sfw-search__cms-fragment";
        String locator = "";
        if (System.getProperty("browserView").contains("desktop")){
            try{
                return driver.findElement(By.cssSelector(cmsFragment + "--desktop" + " section[data-placement-slot-number='" + slotNumber + "']"));
            }
            catch (Exception ex){
            }
            finally {
                return driver.findElement(By.cssSelector(cmsFragment + "--tablet" + " section[data-placement-slot-number='" + slotNumber + "']"));
            }
        }
        else if (System.getProperty("browserView").contains("mobile")){
            return driver.findElement(By.cssSelector(cmsFragment + " section[data-placement-slot-number='" + slotNumber + "']"));
        }
        return null;
    }

    public String getSearchResultsTitle() {
        return getText(resultsTitle).replace("\"", "");
    }

    public void clickOnLink(String linkName) {
        WebElement link = driver.findElement(By.linkText(linkName));
        WebUtils webUtils = new WebUtils(driver);
        webUtils.scrollToElement(link);
        click(link);
    }

    public boolean productTilesContainText(String text) {
        return productTilesContainText(text, false);
    }

    public boolean productTilesContainText(String text, boolean all) {
        int count = 0;
        List<String> textList = Convert.stringToList(text);
        for (WebElement tileTitle : tileTitles) {
            String getText = tileTitle.getText();
            List<String> contentList = Convert.stringToList(getText);
            if (all) {
                if (contentList.containsAll(textList)) count++;
                contentList.removeAll(contentList);
            } else {
                for (String word : textList) {
                    if (getText.indexOf(word) != -1) count++;
                    else count--;
                }
            }
            if (all && (count / 2) == tiles.size()) return true;
            else if (!all && count >= (tiles.size() / 2)) return true;
        }
        return false;
    }

    public boolean productTileTitleContainText(String text, int index) {
        if (tileTitles.get(index).getText().contains(text)) return true;
        else return false;
    }
}
