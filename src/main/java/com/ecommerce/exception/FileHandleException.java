package com.ecommerce.exception;

public class FileHandleException extends RuntimeException {

    public FileHandleException(String message) {
        super(message);
    }

    public FileHandleException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
