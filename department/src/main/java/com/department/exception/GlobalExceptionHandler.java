package com.department.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDeatail> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException,WebRequest webRequest){
        ErrorDeatail errorDeatail = new ErrorDeatail(LocalDateTime.now(),resourceNotFoundException.getMessage(),webRequest.getDescription(false),"Department_Not_Found");
        return new ResponseEntity<>(errorDeatail,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDeatail> handleGlobalException(Exception exception,WebRequest webRequest){
        ErrorDeatail errorDeatail = new ErrorDeatail(LocalDateTime.now(),exception.getMessage(),webRequest.getDescription(false),"Internal_Server_Error");
        return new ResponseEntity<>(errorDeatail,HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
