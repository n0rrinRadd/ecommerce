package com.ecommerce.helpers;

import com.ecommerce.http.RestHttpRequest;
import com.ecommerce.http.RestHttpRequestBuilder;
import com.ecommerce.http.RestHttpResponsePageDetails;
import org.jsoup.nodes.Document;

public class DocumentProcessor {

    public static Document getDocumentResponseBySearchQuery(String searchQuery) {
        return getDocumentResponseBySearchQuery(searchQuery,"", "", false);
    }

    public static Document getDocumentResponseBySearchQuery(String searchQuery, String experimentName, String variation, boolean mobile) {
        return getDocumentResponseByUrl("/s?query=" + searchQuery, experimentName, variation, mobile);
    }

    public static Document getDocumentResponseByUrl(String url) {
        String userAgent = "Mozilla/5.0";
        RestHttpRequestBuilder restHttpRequestBuilder;
        RestHttpRequest restHttpRequest;
        RestHttpResponsePageDetails pageDetails;
        String requestUrl = Environment.getBaseUrl() + url;
        restHttpRequestBuilder = RestHttpRequestBuilder.RestHttpRequest.
                buildGetRequest(requestUrl)
                .addHeader("User-Agent", userAgent).build();
        restHttpRequest = new RestHttpRequest(restHttpRequestBuilder);
        pageDetails = restHttpRequest.fetchPage();
        return pageDetails.getDocument();
    }

    public static Document getDocumentResponseByUrl(String url, String experimentName, String variation, boolean mobile) {
        String userAgent = "Mozilla/5.0";
        if(mobile) userAgent += " (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19";
        RestHttpRequestBuilder restHttpRequestBuilder;
        RestHttpRequest restHttpRequest;
        RestHttpResponsePageDetails pageDetails;
        String requestUrl = Environment.getBaseUrl() + url;
        char queryChar = requestUrl.contains("?") ? '&' : '?';
        restHttpRequestBuilder = RestHttpRequestBuilder.RestHttpRequest.
                buildGetRequest(requestUrl + queryChar + "experimentName=" + experimentName + "&experimentVariation=" + variation)
                .addHeader("User-Agent", userAgent).build();
        restHttpRequest = new RestHttpRequest(restHttpRequestBuilder);
        pageDetails = restHttpRequest.fetchPage();
        return pageDetails.getDocument();
    }

    public static int countProductsDisplayedOnPage(Document doc, boolean mobile) {
        // On mobile, each search result (product) is surrounded by an <article> tag with class .search-item
        // On desktop, each search result (product) is surrounded by an <article> tag with class .product-holder
        // A class ".search-items" exists also, so the regex guarantees that we do not match more than we intend
        String tag;
        if(mobile) tag = "search-item[^s]";
        else tag = "product-holder";
        int productCount = doc.body().toString().split(tag).length-1;

        return productCount;
    }
}
