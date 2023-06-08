package com.ecommerce.exception;

public class TaskExecutionException extends RuntimeException {

    public TaskExecutionException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
