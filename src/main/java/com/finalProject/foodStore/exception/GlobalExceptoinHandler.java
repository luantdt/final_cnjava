package com.finalProject.foodStore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.finalProject.foodStore.jwt.ResponseObject;

@RestControllerAdvice
public class GlobalExceptoinHandler {
	@ExceptionHandler(BindException.class)
	public ResponseEntity<ResponseObject> handleBindException(BindException e) {

		String errorMessage = "invalid request";
		if (e.getBindingResult().hasErrors())
			errorMessage = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new ResponseObject("fail", "Your request is not valid", errorMessage));
	}
}
