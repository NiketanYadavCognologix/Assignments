package com.cognologix.bankingApplication.exceptions;

public class AccountAlreadyExistException extends RuntimeException {
    public AccountAlreadyExistException() {
    }

    public AccountAlreadyExistException(String message) {
        super(message);
    }
}
