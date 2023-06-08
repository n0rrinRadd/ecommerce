package com.ecommerce.http;

public class RestHttpSearchRequest2 {

    public static void main(String[] args) {
        String uri = "https://www-stg.ecommerce.net/blue-buffalo-life-protection-formula/dp/32041";

        RestHttpRequestBuilder restHttpRequestBuilder = RestHttpRequestBuilder
                .RestHttpRequest
                .buildGetRequest(uri)
                .addHeader("User-Agent", "Mozilla/5.0").build();

        RestHttpRequestHandler restHttpRequestHandler = new RestHttpRequestHandler(restHttpRequestBuilder);
        RestHttpResponsePageDetails restHttpResponseDetails = restHttpRequestHandler.fetchPage();
        System.out.println();
    }
}
