package com.RESTAPI.RESTAPIEXAMPLE.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
    //ResourceNotFound Exception Handle Globally
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException, WebRequest webRequest){
            ErrorDetails errorDetails=new ErrorDetails(new Date(),resourceNotFoundException.getMessage(),webRequest.getDescription(false));
            return new   ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception exception, WebRequest webRequest){
        ErrorDetails errorDetails=new ErrorDetails(new Date(),exception.getMessage(),webRequest.getDescription(false));
        return new   ResponseEntity(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
