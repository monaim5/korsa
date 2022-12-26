package com.suka.korsa.filter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;

record ExceptionDto(
		String message
) { }

@ControllerAdvice
public class ExceptionFilter {

	@ExceptionHandler(value = {EntityNotFoundException.class})
	public ResponseEntity<ExceptionDto> handle404(RuntimeException ex) {
		return new ResponseEntity<>(new ExceptionDto(ex.getMessage()), HttpStatus.BAD_REQUEST);
	}
}

