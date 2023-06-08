package com.ecommerce.http;

import java.util.List;

/**
 * Base entry point for making all http requests.
 */
public class RestHttpRequest {

    private final RestHttpRequestHandler restHttpRequestHandler;

    public RestHttpRequest(RestHttpRequestBuilder restHttpRequestBuilder) {
        restHttpRequestHandler = new RestHttpRequestHandler(restHttpRequestBuilder);
    }

    public RestHttpResponsePageDetails fetchPage() {
        return restHttpRequestHandler.fetchPage();
    }

    public byte[] fetchResponseAsBytes() {
        return restHttpRequestHandler.fetchResponseAsBytes();
    }

    public <T> T fetchResponseAsObject(Class<T> classToDeserializeTo) {
        return restHttpRequestHandler.fetchResponseAsObject(classToDeserializeTo);
    }

    public <T> List<T> fetchResponseAsObjectList(Class<T> classToDeserializeTo) {
        return restHttpRequestHandler.fetchResponseAsObjectList(classToDeserializeTo);
    }
}
