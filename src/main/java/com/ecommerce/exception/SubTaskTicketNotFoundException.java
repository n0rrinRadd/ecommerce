package com.ecommerce.exception;

public class SubTaskTicketNotFoundException extends RuntimeException {

    public SubTaskTicketNotFoundException(String message) {
        super(message);
    }

    public SubTaskTicketNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}




