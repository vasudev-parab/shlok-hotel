package com.infy.mli.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.infy.mli.dto.Response;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Response> handleMethodArgsNotvalidException(MethodArgumentNotValidException ex)
	{
Response response=new Response();
		
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String message=error.getDefaultMessage();
//			String fieldName=((FieldError)error).getField();
			
			response.setMessage(message);
			response.setStatus("Fail");
		});
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}
}
