package com.wipro.ucms.util;

public class TechnicianNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	private String message;
	public TechnicianNotFoundException(String message) {
		this.message=message;
	}
	@Override
	public String toString() {
		return message;
}
}
