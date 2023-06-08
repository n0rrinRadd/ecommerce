package com.ecommerce.exception;

public class IssueNotFoundException extends RuntimeException {

    public IssueNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
