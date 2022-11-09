package com.cognologix.HttpMethods.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class IdNotFoundExceptionHandler {

	@ExceptionHandler(value = IdNotFoundException.class)
	public ResponseEntity<String> handledIdNotFoundException(Exception exception)
	{
		return new ResponseEntity<String>("Exception: "+exception.getMessage(),HttpStatus.BAD_REQUEST);
		
	}
}
