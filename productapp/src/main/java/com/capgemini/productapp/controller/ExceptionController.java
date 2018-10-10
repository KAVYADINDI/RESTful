package com.capgemini.productapp.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.capgemini.productapp.entity.ErrorMessage;
import com.capgemini.productapp.exceptions.ProductNotFoundException;


@Controller
public class ExceptionController {

Logger log = LoggerFactory.getLogger(this.getClass());


    @ExceptionHandler(value = ProductNotFoundException.class)
	public  ResponseEntity<ErrorMessage> customerNotFoundException(
			ProductNotFoundException customerNotFoundException, HttpServletRequest request) {
		ErrorMessage errorMessage = new ErrorMessage(request.getRequestURI(), HttpStatus.NOT_FOUND,
				LocalDateTime.now(), customerNotFoundException.getMessage());
		log.error(errorMessage.toString());
		return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
	}
}
