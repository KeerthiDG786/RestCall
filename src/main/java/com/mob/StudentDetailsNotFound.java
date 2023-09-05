package com.mob;

public class StudentDetailsNotFound {
	
	private String message;
	private int statusCode;
	public StudentDetailsNotFound(String message, int statusCode) {
		super();
		this.message = message;
		this.statusCode = statusCode;
	}
	public StudentDetailsNotFound() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	@Override
	public String toString() {
		return "StudentDetailsNotFound [message=" + message + ", statusCode=" + statusCode + "]";
	}
	

}
