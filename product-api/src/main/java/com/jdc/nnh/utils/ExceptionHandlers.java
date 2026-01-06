package com.jdc.nnh.utils;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlers {
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	List<String> handle(MethodArgumentNotValidException e){
		return e.getFieldErrors()
				.stream().map(error -> error.getDefaultMessage()).toList();
	}
	
//	@ExceptionHandler({
//		CategoryNotFoundException.class,
//		ItemNotFoundException.class
//		})
//	public ResponseEntity handlingException(Exception ex, WebRequest request) throws Exception{
//		return handleExceptionInternal(ex, message(ex), new HttpHeaders(),HttpStatus.BAD_REQUEST, request);
//	}
//	
//	public ApiError message(Exception ex) {
//		String msg = ex != null ? ex.getMessage() : "UNKNOWN ERROR!";
//		return new ApiError(HttpStatus.BAD_REQUEST.value(),
//							LocalDateTime.now() ,
//							msg);
//	}

}
