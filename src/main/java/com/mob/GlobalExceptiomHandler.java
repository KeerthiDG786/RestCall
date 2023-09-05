package com.mob;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptiomHandler extends ResponseEntityExceptionHandler {

	
	 @ExceptionHandler(DetailsNotFound.class)
	 @ResponseStatus(HttpStatus.BAD_REQUEST)
	 public ResponseEntity<Object> studentNotFound(DetailsNotFound st,WebRequest web)
	{
		
		return new ResponseEntity<>(st.getMessage(),HttpStatus.BAD_REQUEST);
	}	 
	 HttpStatusCode status;

		/*
		 * @ExceptionHandler(NoSuchElementException.class)
		 * 
		 * @ResponseStatus(HttpStatus.BAD_REQUEST) public ResponseEntity<String>
		 * handleNoSuchElementException(NoSuchElementException exception) {
		 * 
		 * return new
		 * ResponseEntity<String>("error : details not found",HttpStatus.BAD_REQUEST);
		 * 
		 * }
		 */
	
}
