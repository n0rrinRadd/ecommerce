package com.ecommerce.pages.storefront;

import com.ecommerce.pages.storefront.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class LoginPage extends BasePage {

    @FindBy(css = "label[for='username']")
    private WebElement userNameLbl;

    @FindBy(css = "input[id='username']")
    private WebElement userNameTextField;

    @FindBy(css = "input[id='password']")
    private WebElement passwordTextField;

    @FindBy(css = "[type='submit'][value='Sign In']")
    private WebElement signInButton;

    @FindBy(id = "forgotPassword")
    private WebElement forgotPasswordLink;

    @FindBy(css = "a[href='/app/register?url=%2Fapp%2Faccount']")
    private WebElement createAccountButton;


    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * From the login page, enter the username / email
     * @param email Users email address
     */
    private void enterLogonEmail(String email) {
        userNameTextField.clear();
        userNameTextField.sendKeys(email);
    }

    /**
     * From the login page, enter the user password
     * @param password password to enter into the login page
     */
    private void enterLogonPassword(String password) {
        passwordTextField.clear();
        passwordTextField.sendKeys(password);
    }

    /**
     * <p>Assumes the Login page is currently loaded (not the HomePage)</p>
     * <p>Waits for the Username field has become available bofer trying
     * to start username / password entry</p>
     * <p>Does not wait or check for login success / failure.</p>
     * @param logonEmail Users login email address
     * @param logonPassword Users login password
     */
    public void login(String logonEmail, String logonPassword) {
        wait.until(elementToBeClickable(userNameTextField));
        enterLogonEmail(logonEmail);
        enterLogonPassword(logonPassword);
        wait.until(elementToBeClickable(signInButton));
        signInButton.click();
    }

}