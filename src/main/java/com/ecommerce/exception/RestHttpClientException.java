package com.ecommerce.exception;

public class RestHttpClientException extends RuntimeException {

    public RestHttpClientException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public RestHttpClientException(String message) {
        super(message);
    }
}
