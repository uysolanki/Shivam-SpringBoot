package com.itp.sms.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.itp.sms.response.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

//@ExceptionHandler(PlayerNotFoundException.class)
//public ResponseEntity<String> handlePlayerNotFound(PlayerNotFoundException ex)
//{
//	return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
//}


//@ExceptionHandler(PlayerNotFoundException.class)
//public ResponseEntity<Map<String, Object>> handlePlayerNotFound(PlayerNotFoundException ex)
//{
//		Map<String, Object> body = new HashMap<>();
//		    body.put("error", "Player Not Found");
//		    body.put("message", ex.getMessage());
//		    body.put("timestamp", LocalDateTime.now());
//		return new ResponseEntity<Map<String, Object>>(body,HttpStatus.NOT_FOUND);
//
//}

@ExceptionHandler(PlayerNotFoundException.class)
public ResponseEntity<ErrorResponse> handlePlayerNotFound(PlayerNotFoundException ex)
{
		ErrorResponse error=new ErrorResponse("Player Not Found",ex.getMessage(),LocalDateTime.now(),HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorResponse>(error,HttpStatus.NOT_FOUND);

}

}