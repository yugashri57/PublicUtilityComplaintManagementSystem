package com.wipro.ucms.util;

public class ComplaintNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	private String message;
	public ComplaintNotFoundException(String message) {
		this.message=message;
	}
	@Override
	public String toString() {
		return message;
	}
}
