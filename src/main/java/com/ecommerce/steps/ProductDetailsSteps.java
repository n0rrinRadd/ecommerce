package com.ecommerce.steps;

import com.ecommerce.helpers.Environment;
import io.cucumber.java.en.Then;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ProductDetailsSteps {

    WebDriver driver;
    SoftAssertions softly;

    private BaseDriver baseDriver;

    public ProductDetailsSteps(BaseDriver baseDriver) {
        this.baseDriver = baseDriver;
        this.driver = baseDriver.getDriver();
        this.softly = new SoftAssertions();
    }

    @Then("the {} page returns status code {int}")
    public void the_page_returns_status_code(String url, int statusCode) throws Throwable {
        int code = 0;
        try {
            URL obj = new URL(Environment.getBaseUrl() + url);
            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
            conn.setReadTimeout(5000);
            conn.addRequestProperty("Accept-Language", "en-US,en;q=0.8");
            conn.addRequestProperty("User-Agent", "Mozilla");
            conn.addRequestProperty("Referer", "google.com");
            code = conn.getResponseCode();
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }
        softly.assertThat(code).isEqualTo(statusCode);
        softly.assertAll();
    }
}