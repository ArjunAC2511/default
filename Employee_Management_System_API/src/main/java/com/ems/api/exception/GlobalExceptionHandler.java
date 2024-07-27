package com.ems.api.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<Map<String, Object>> handleBadRequestException(BadRequestException ex) {

		Map<String, Object> errorDetails = new HashMap<>();
		errorDetails.put("message", ex.getMessage());
		errorDetails.put("status", HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(InvalidException.class)
	public ResponseEntity<Map<String, Object>> handleInvalidException(InvalidException ex) {

		Map<String, Object> errorDetails = new HashMap<>();
		errorDetails.put("message", ex.getMessage());
		errorDetails.put("status", HttpStatus.FORBIDDEN.value());
		return new ResponseEntity<>(errorDetails, HttpStatus.FORBIDDEN);
	}

	@ExceptionHandler(InActiveException.class)
	public ResponseEntity<Map<String, Object>> handleInActiveException(InActiveException ex) {

		Map<String, Object> errorDetails = new HashMap<>();
		errorDetails.put("message", ex.getMessage());
		errorDetails.put("status", HttpStatus.UNAUTHORIZED.value());
		return new ResponseEntity<>(errorDetails, HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<Map<String, Object>> handleNotFoundException(NotFoundException ex) {

		Map<String, Object> errorDetails = new HashMap<>();
		errorDetails.put("message", ex.getMessage());
		errorDetails.put("status", HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
}
