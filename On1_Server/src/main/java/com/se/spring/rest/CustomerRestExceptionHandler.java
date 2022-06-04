package com.se.spring.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.se.spring.entity.CustomerErrResp;

@ControllerAdvice
public class CustomerRestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<CustomerErrResp> handleExc(CustomerNotFoundExc exc){
		CustomerErrResp err = new CustomerErrResp(
					HttpStatus.BAD_REQUEST.value(),
					exc.getMessage(),
					System.currentTimeMillis()
				);
		
		return new ResponseEntity<CustomerErrResp>(err, HttpStatus.BAD_REQUEST);
	}
}
