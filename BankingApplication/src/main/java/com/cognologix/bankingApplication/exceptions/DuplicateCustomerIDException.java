package com.cognologix.bankingApplication.exceptions;

public class DuplicateCustomerIDException extends RuntimeException{
    public DuplicateCustomerIDException() {
    }

    public DuplicateCustomerIDException(String message) {
        super(message);
    }
}
