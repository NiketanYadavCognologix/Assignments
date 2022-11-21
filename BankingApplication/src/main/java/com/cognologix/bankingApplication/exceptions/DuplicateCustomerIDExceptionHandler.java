package com.cognologix.bankingApplication.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DuplicateCustomerIDExceptionHandler {
    @ExceptionHandler(DuplicateCustomerIDException.class)
    public ResponseEntity<String> handleDuplicateCustomerIDException(Exception exception){
        return new ResponseEntity<String>("Exception : "+exception, HttpStatus.BAD_REQUEST);
    }
}
