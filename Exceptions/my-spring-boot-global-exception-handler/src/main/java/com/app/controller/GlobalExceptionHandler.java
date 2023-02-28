package com.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.annotation.Priority;
import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@Priority(10)
public class GlobalExceptionHandler {

    @ExceptionHandler({NullPointerException.class})
    public ResponseEntity<String> nullPointerException(NullPointerException ex, HttpServletRequest request){
        System.out.println("!!!!!!!!!!!!!!!globalHandler");
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.FORBIDDEN);
    }
}
