package com.mathew.corejava.designs.chatserver;

public class ChartServerException extends Exception {
	int errorCode;
	String message;

	public ChartServerException() {

	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}