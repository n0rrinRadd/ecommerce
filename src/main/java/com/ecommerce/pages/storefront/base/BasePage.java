package com.ecommerce.pages.storefront.base;

import com.ecommerce.helpers.Environment;
import com.ecommerce.utils.WebUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

public class BasePage extends Environment {

    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, 30);
    }

    /**
     * <p>Using WebDriverWait to check for visibility of the passed {@linkWebElement}</p>
     * <p>Visible means that the element has been rendered and is visable
     * somewhere on the screen.</p>
     * <p>See @see waitForClickabilityOfElement for details.</p>
     *
     * @param element WebElement to inspect
     */
    public void waitForVisibilityOfElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * <p>Using WebDriverWait to check for clickability of the passed {@link WebElement}</p>
     * <p>Clickable means that the element has been renddered, is visiable, AND not
     * obscured by other element, making it clickable.</p>
     * <p>Clickable is more stringent than the Visible</p>
     * <p>See @see waitForVisibilityOfElement for details</p>
     *
     * @param element WebElement to inspect
     */
    public void waitForClickabilityOfElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public boolean isElementPresent(WebElement element) {
        waitForVisibilityOfElement(element);
        return element.isDisplayed();
    }

    /**
     * <p>A safer version of the selenium click method.  This
     * click method waits for the element to be clickable before
     * attempting to execute the native click method.</p>
     *
     * @param element WebElement to click
     */
    public String   click(WebElement element) {
        WebUtils webUtils = new WebUtils(driver);
        webUtils.scrollToElement(element);
        element.click();
        return driver.getCurrentUrl();
    }

    /**
     * <p>A safer version of the selenium submit method.  This
     * submit method waits for the element to be submitable before
     * attempting to execute the native submit method.</p>
     *
     * @param element WebElement to submit
     */
    public void submit(WebElement element) {
        waitForVisibilityOfElement(element);
        element.submit();
    }

    /**
     * <p>A safer version of the selenium clear method. This
     * method waits for visibilty of element before attempting
     * to call the native selenium clear method.</p>
     *
     * @param element
     */
    public void clear(WebElement element) {
        waitForVisibilityOfElement(element);
        element.click();
    }

    /**
     * <p>Enhanced sendKeys method.  This version waits for element
     * to be visible, checks the existing length, and removes
     * exist data entered.  Note that React data entry fields
     * do NOT respond to selenium clear() method.</p>
     *
     * @param element Element to enter string into
     * @param keyword String to send to passed WebElement
     */
    public void sendKeys(WebElement element, String keyword) {
        waitForVisibilityOfElement(element);
        int existingEntryLength = element.getAttribute("value").length();
        if (existingEntryLength > 0) {
            ArrayList<CharSequence> BS = new ArrayList<>(Collections.nCopies(existingEntryLength, Keys.BACK_SPACE));
            ArrayList<CharSequence> DEL = new ArrayList<>(Collections.nCopies(existingEntryLength, Keys.DELETE));
            BS.addAll(DEL);
            element.sendKeys(BS.toArray(new CharSequence[0]));
        }
        element.click();
        element.sendKeys(keyword == null ? "" : keyword);
        element.sendKeys(Keys.TAB);
    }

    /**
     * <p>Wait for element to be visible, and then extract text from passed WebElement
     * and return as a string</p>
     *
     * @param element WebElement to inspect
     * @return string data returned by .getText() method
     */
    public String getText(WebElement element) {
        waitForVisibilityOfElement(element);
        return element.getText();
    }

    /**
     * <p>Get all the child elements of the passed WebElement.</p>
     * <p>Useful in cases where a list of sub elements are available
     * list a list of postal addresses or items in a cart</p>
     *
     * @param parentElement       The enclosing WebElement
     * @param childElementLocator Filter to use to find child elements
     * @return Zero or more elements found, does NOT return null if no elements found
     */
    public List<WebElement> getChildElements(WebElement parentElement,
                                             By childElementLocator) {
        try {
            waitForVisibilityOfElement(parentElement);
            return parentElement.findElements(childElementLocator);
        } catch (ClassCastException | WebDriverException e) {
            return Collections.emptyList();
        }
    }

    /**
     * <p>Wait for element to be visible, and then extract a specific attribute value</p>
     *
     * @param element   WebElement to inspect
     * @param attribute Name of attribute to extract
     * @return String of the attributes value
     */
    public String getAttribute(WebElement element, String attribute) {
        waitForVisibilityOfElement(element);
        return element.getAttribute(attribute);
    }

    /**
     * <p>Get the browsers current URL</p>
     *
     * @return String of the current url
     */
    public String getUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * <p>Wait for WebElement to be visible, then locate zero or more
     * WebElements and return them in a list</p>
     *
     * @param element WebElement to wait for visibility, typically the enclosing element
     * @param by      By class to use to find elements anywhere on the page
     * @return List of zero or more WebElements
     */
    public List<WebElement> findElementsBy(WebElement element, By by) {
        waitForVisibilityOfElement(element);
        return element.findElements(by);
    }

    /**
     * <p>Wait for WebElement to be visible, then locate zero or first
     * WebElement</p>
     *
     * @param element WebElement to wait for visibility, typically the enclosing element
     * @param by      By class to use to find elements anywhere on the page
     * @return First WebElement found
     */
    public WebElement findElementBy(WebElement element, By by) {
        waitForVisibilityOfElement(element);
        return findElementsBy(element, by).get(0);
    }

    public void selectValue(WebElement element, String keyword) {
        waitForClickabilityOfElement(element);
        Select select = new Select(element);
        select.selectByVisibleText(keyword);
        wait.until(textToBePresentInElement(element, keyword));
    }

    public static String getBaseUrl(){
        return Environment.getBaseUrl();
    }

    /**
     * <p>Go to a specific URL in the brawser</p>
     */
    public void goTo(){
        driver.navigate().to(getStorefrontBaseUrl());
    }

    public void goTo(String appendedUrl){
        driver.navigate().to(getStorefrontBaseUrl());
        driver.navigate().to(getBaseUrl() + appendedUrl);
    }
}