package com.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.annotation.Priority;
import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@Priority(1)//lower number has more priority
public class GlobalExceptionHandler2 {

    @ExceptionHandler({NullPointerException.class})
    public ResponseEntity<String> nullPointerException(NullPointerException ex, HttpServletRequest request){
        System.out.println("!!!!!!!!!!!!!!!globalHandler2");
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.FORBIDDEN);
    }
}
