package com.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler3 {

    @ExceptionHandler({ArrayIndexOutOfBoundsException.class})
    public ResponseEntity<String> arrayIndexOutOfBoundsException(ArrayIndexOutOfBoundsException ex, HttpServletRequest request){
        System.out.println("!!!!!!!!!!!!!!!globalHandler3");
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.FORBIDDEN);
    }
}
