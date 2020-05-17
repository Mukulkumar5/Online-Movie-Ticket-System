package com.onlinemovie.city.exception;

import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
public class CityException extends Exception{
	
	private String msg;
	private HttpStatus status;

	public CityException(String errorMessage) {
		super(errorMessage);
	}
	
	
	public CityException(String msg, HttpStatus status){
		
		this.msg = msg;
		this.status = status;
		
	}
	CityException(
	  HttpStatus status, 
	  java.lang.String reason, 
	  java.lang.Throwable cause
	){
		
	}
	
	
}
