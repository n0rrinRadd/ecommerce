package com.ecommerce.driver;

import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import static io.github.bonigarcia.wdm.WebDriverManager.getInstance;
import static io.github.bonigarcia.wdm.config.DriverManagerType.CHROME;
import static io.github.bonigarcia.wdm.config.DriverManagerType.FIREFOX;

public class DriverFactory {

    private WebDriver driver = null;
    public static Capabilities caps;

    public DriverManagerType getType(){
        String value = System.getProperty("browserType", "chrome");
        switch (value) {
            case "chrome":
                return CHROME;
            case "firefox":
                return FIREFOX;
            default:
                throw new IllegalStateException(value + " is not a supported");
        }
    }

    public WebDriver getDriver(String testName) {
        DriverManagerType type = getType();
        String value = System.getProperty("browserEnv", "grid").toLowerCase();
        System.setProperty("webdriver.chrome.silentOutput", "true"); //THIS will surpress all logs expect INFO
        java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE); // this could be used to stop INFO logging in chrome driver
        String browserView = System.getProperty("browserView", "desktop");
        switch (value){
            case "local":
                getInstance(type).setup();
                switch (type) {
                    case CHROME:
                        ChromeOptions options = new ChromeOptions();
                        if (System.getProperty("browserMode", "gui").contains("headless")){
                            options.addArguments("--headless"); //https://developers.google.com/web/updates/2017/04/headless-chrome
                        }
                        if (browserView.contains("mobile") || browserView.contains("tablet")){
                            String deviceName = "";
                            if (browserView.contains("mobile")) deviceName = "Nexus 5";
                            else if (browserView.contains("tablet")) deviceName = "iPad Mini";
                            Map<String, String> mobileEmulation = new HashMap<>();
                            mobileEmulation.put("deviceName", System.getProperty("deviceName", deviceName)); //https://chromedriver.chromium.org/mobile-emulation
                            options.setExperimentalOption("mobileEmulation", mobileEmulation);
                        }
                        options.addArguments("--disable-gpu");
                        return new ChromeDriver(options);
                    case FIREFOX:
                        return new FirefoxDriver();
                }
            case "grid":
                caps = new Capabilities();
                String gridHub = System.getProperty("gridHub", "http://fll2gselpoc.ecommerce.local");
                try {
                    return new RemoteWebDriver(new URL(gridHub + ":4444/wd/hub"), caps.getLatestGridBrowser(type, testName));
                }
                catch (MalformedURLException ex){
                    ex.printStackTrace();
                }
            case "sauce":
                caps = new Capabilities();
                try{
                    return new RemoteWebDriver(new URL("https://ondemand.saucelabs.com:443/wd/hub"), caps.getLatestSauceBrowser(type, testName));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            default:
                throw new IllegalStateException(value + " is not a supported");
        }
    }
}
