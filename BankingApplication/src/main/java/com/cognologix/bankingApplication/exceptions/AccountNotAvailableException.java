package com.cognologix.bankingApplication.exceptions;

public class AccountNotAvailableException extends RuntimeException{
    public AccountNotAvailableException() {
    }

    public AccountNotAvailableException(String message) {
        super(message);
    }
}
