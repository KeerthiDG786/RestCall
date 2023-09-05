package com.mob;

import org.springframework.http.HttpStatus;

public class DetailsNotFound extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String message;
    private HttpStatus status;
	public DetailsNotFound(String message,HttpStatus status) {
		super();
		this.message = message;
		this.status=status;
	}

	
	public HttpStatus getStatus() {
		return status;
	}


	public String getMessage() {
		return message;
	}


	@Override
	public String toString() {
		return "StudentDetailsNotFound [message=" + message + ", status=" + status + "]";
	}
    
	

}
