package com.stackly.demo.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import com.stackly.demo.dto.APIResponse;


@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResource(ResourceNotFoundException ex)
	{
		APIResponse<?> response = new APIResponse<>(LocalDateTime.now(),
				404,ex.getMessage(),null);
		return ResponseEntity.status(404).body(response);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> validationException(MethodArgumentNotValidException ex)
	{
		Map<String,String> errors =new HashMap<>();
		ex.getBindingResult()
		.getFieldErrors()
		.forEach(error ->
		errors.put(error.getField(),error.getDefaultMessage()));
		return ResponseEntity.badRequest().body(errors);

	}
}
