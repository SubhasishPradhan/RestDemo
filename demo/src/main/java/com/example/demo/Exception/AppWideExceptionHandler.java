package com.example.demo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppWideExceptionHandler {

	@ExceptionHandler(InvalidInput.class)
	protected ResponseEntity<Object> inValidInput(InvalidInput invalidInput) {
		return new ResponseEntity<>(invalidInput.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
