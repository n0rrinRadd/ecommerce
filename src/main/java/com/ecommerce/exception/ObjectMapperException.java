package com.ecommerce.exception;

public class ObjectMapperException extends RuntimeException {

    public ObjectMapperException(String message, Throwable throwable){
        super(message, throwable);
    }
}
