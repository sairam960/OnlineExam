package com.lti.exception;

public class AdminServiceException extends RuntimeException{

	public AdminServiceException() {
		super();
		
	}

	public AdminServiceException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public AdminServiceException(String message) {
		super(message);
		
	}

	public AdminServiceException(Throwable cause) {
		super(cause);
		
	}

	
}
