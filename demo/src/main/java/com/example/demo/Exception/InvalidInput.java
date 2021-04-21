package com.example.demo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidInput extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidInput() {
		super();
	}

	public InvalidInput(String message) {
		super(message);
	}

}
