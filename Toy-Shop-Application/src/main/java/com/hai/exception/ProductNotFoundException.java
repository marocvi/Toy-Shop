package com.hai.exception;

public class ProductNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String errorCode;
	private String errorMsg;
	
	
	public ProductNotFoundException() {
		errorMsg = "Can't find product match";
	}
	
	@Override
	public String getMessage() {
		return errorMsg;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	

	
}
