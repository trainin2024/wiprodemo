package com.cg.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
//https://developer.mozilla.org/en-US/docs/Web/HTTP/Status
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidIDException extends Exception {
	 public InvalidIDException(String message){
	        super(message);
	    }
	
}
