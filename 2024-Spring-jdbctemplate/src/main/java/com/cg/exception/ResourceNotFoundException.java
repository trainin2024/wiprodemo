package com.cg.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
//https://developer.mozilla.org/en-US/docs/Web/HTTP/Status
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception {
	 public ResourceNotFoundException(String message){
	        super(message);
	    }
	
}
