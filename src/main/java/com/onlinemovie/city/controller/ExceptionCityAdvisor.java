package com.onlinemovie.city.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.onlinemovie.city.exception.AllException;
import com.onlinemovie.city.exception.CityException;


@RestControllerAdvice
public class ExceptionCityAdvisor {

	@ExceptionHandler(AllException.class)
	public ResponseEntity<String> handleCityExceptionAction(AllException exp){
		return new ResponseEntity<String>(exp.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CityException.class)
	public ResponseEntity<String> handleCityAction(Exception exp){
		return new ResponseEntity<String>(exp.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
