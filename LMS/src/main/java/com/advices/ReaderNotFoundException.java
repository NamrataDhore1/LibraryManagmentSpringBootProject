package com.advices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ReaderNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;
	public ReaderNotFoundException(String message){
        super(message);
    }

}
