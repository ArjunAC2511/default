package com.admin.exception;

@SuppressWarnings("serial")
public class TutorNotFoundException extends RuntimeException {
	
    public TutorNotFoundException(String message) {
        super(message);
    }
}

