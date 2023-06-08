package com.ecommerce.e2e.storefront.base;


import com.ecommerce.AbstractTest;
import com.ecommerce.http.RestHttpRequest;
import com.ecommerce.http.RestHttpRequestBuilder;
import org.jsoup.nodes.Document;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public abstract class HeadlessView extends AbstractTest {

    public WebDriver driver;

    @BeforeMethod(alwaysRun=true)
    public void BeforeMethod(ITestContext context, Method m){
        context.getCurrentXmlTest().getSuite().setDataProviderThreadCount(1);
        context.getCurrentXmlTest().getSuite().setPreserveOrder(false);
        System.setProperty("browserView", "desktop");
        System.setProperty("browserMode", "headless");
        driver = startWebDriver(m.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void After(){
        driver.quit();
    }

    public RestHttpRequest getRequest(String url, String headerKey, String headerValue){
        RestHttpRequestBuilder restHttpRequestBuilder = RestHttpRequestBuilder.RestHttpRequest.buildGetRequest(getBaseUrl() + "")
                .addHeader(headerKey, headerValue).build();
        return new RestHttpRequest(restHttpRequestBuilder);
    }

    public Document getDocumentResponse(RestHttpRequest request){
        return request.fetchPage().getDocument();
    }
}