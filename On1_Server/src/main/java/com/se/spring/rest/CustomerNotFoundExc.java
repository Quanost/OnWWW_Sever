package com.se.spring.rest;

public class CustomerNotFoundExc extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerNotFoundExc(String message, Throwable cause) {
		super(message, cause);
	}
	
	public CustomerNotFoundExc(String message) {
		super(message);
	}
	
	public CustomerNotFoundExc(Throwable cause) {
		super(cause);
	}
}
