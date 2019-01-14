package com.hai.exception;

public class NotExistTokenException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "This token doesn't exist";
	}

}
