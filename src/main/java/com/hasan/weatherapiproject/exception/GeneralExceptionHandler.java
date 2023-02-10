package com.hasan.weatherapiproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(AdressTimeNotFoundException.class)
    public ResponseEntity<?> adressTimeNotFoundExceptionHandler(AdressTimeNotFoundException exception){
        return new ResponseEntity<>(exception.getMessage(),HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequestExceptionHandler(BadRequestException exception){
        return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
    }
}
