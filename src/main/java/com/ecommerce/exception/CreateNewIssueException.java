package com.ecommerce.exception;

public class CreateNewIssueException extends RuntimeException {

    public CreateNewIssueException(String message, Throwable throwable){
        super(message, throwable);
    }
}
