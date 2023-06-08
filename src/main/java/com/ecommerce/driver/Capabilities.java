package com.ecommerce.driver;

import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariOptions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

;

public class Capabilities {

    public String sauceUserName(){ return System.getProperty("sauceUserName", "cgrandoitecommerce"); }
    public String sauceAccessKey(){ return System.getProperty("sauceAccessKey", "86bace8f-1c94-46dc-83b4-626d444481da"); }

    /**
     * CAPABILITIES - https://wiki.saucelabs.com/display/DOCS/Platform+Configurator#/
     * @param type
     * @param testName
     * @return
     */
    public MutableCapabilities getLatestSauceBrowser(DriverManagerType type, String testName) {
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("username", sauceUserName());
        sauceOptions.setCapability("accessKey", sauceAccessKey());
        List<String> tags = Arrays.asList("sauceDemo", "demoTest", "module4", "javaTest");
        sauceOptions.setCapability("tags", tags);
        sauceOptions.setCapability("maxDuration", 3600);
        sauceOptions.setCapability("commandTimeout", 600);
        sauceOptions.setCapability("idleTimeout", 1000);
        //sauceOpts.setCapability("build", "Test Build");
        sauceOptions.setCapability("name", testName);
        sauceOptions.setCapability("tunnelIdentifier", "sc-proxy-tunnel");
        switch (type) {
            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setExperimentalOption("w3c", true);
                chromeOptions.setCapability("platformName", "Windows 10");
                chromeOptions.setCapability("browserVersion", "latest");
                chromeOptions.setCapability("sauce:options", sauceOptions);
                return chromeOptions;
            case FIREFOX:
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setCapability("platformName", "Windows 10");
                firefoxOptions.setCapability("browserVersion", "latest");
                firefoxOptions.setCapability("sauce:options", sauceOptions);
                return firefoxOptions;
            case IEXPLORER:
                InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
                internetExplorerOptions.setCapability("platformName", "Windows 10");
                internetExplorerOptions.setCapability("browserVersion", "latest");
                internetExplorerOptions.setCapability("sauce:options", sauceOptions);
                return internetExplorerOptions;
            case EDGE:
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setCapability("platformName", "Windows 10");
                edgeOptions.setCapability("browserVersion", "latest");
                edgeOptions.setCapability("sauce:options", sauceOptions);
                return edgeOptions;
            case SAFARI:
                SafariOptions safariOptions = new SafariOptions();
                safariOptions.setCapability("platformName", "macOS 10.15");
                safariOptions.setCapability("browserVersion", "latest");
                safariOptions.setCapability("sauce:options", sauceOptions);
                return safariOptions;
            default:
                break;
        }
        return null;
    }


    /**
     * CAPABILITIES - http://fll2gselpoc.ecommerce.local:8080/#/capabilities/
     * @param type
     * @return
     */
    public DesiredCapabilities getLatestGridBrowser(DriverManagerType type, String testName) {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        String version = System.getProperty("browserVersion", "latest");
        String browser = type.name().toLowerCase();
        capabilities.setBrowserName(browser);
        switch (type) {
            case CHROME:
                switch (version){
                    case "67.0":
                    case "66.0":
                        capabilities.setVersion(version);
                        break;
                    case "latest":
                        capabilities.setVersion("66.0");
                        break;
                    case "61.0":
                    case "65.0":
                        throw new IllegalStateException("version:" + version + " is not currently working on Selendroid UI");
                    default:
                        throw new IllegalStateException("version:" + version + " is not currently supported on Selendroid UI");
                }
                ChromeOptions options = new ChromeOptions();
                if (System.getProperty("browserMode", "gui").contains("headless")){
                    options.addArguments("--headless"); //https://developers.google.com/web/updates/2017/04/headless-chrome
                }
                if (System.getProperty("browserView", "desktop").contains("mobile")){
                    Map<String, Object> deviceMetrics = new HashMap<>();
                    deviceMetrics.put("width", 360);
                    deviceMetrics.put("height", 640);
                    deviceMetrics.put("pixelRatio", 3.0);
                    Map<String, Object> mobileEmulation = new HashMap<>();
                    mobileEmulation.put("deviceMetrics", deviceMetrics);
                    mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19");
                    options.setExperimentalOption("mobileEmulation", mobileEmulation);
                }
                options.addArguments("--disable-gpu");
                capabilities.setCapability("name", testName);
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                break;

            case FIREFOX:
                switch (version){
                    case "60.0":
                    case "59.0":
                        capabilities.setVersion(version);
                        break;
                    case "latest":
                        capabilities.setVersion("60.0");
                        break;
                    default:
                        throw new IllegalStateException("version:" + version + " is not supported");
                }
                capabilities.setCapability("name", testName);
                break;

            default:
                break;

        }
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);
        return capabilities;
    }
}
