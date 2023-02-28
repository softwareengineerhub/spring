package com.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class MyController {

    @GetMapping("/get")
    public String get(){
        String text = "mytext";
        System.out.println(text);
        String s = null;
        s.toLowerCase();
        return text;
    }

    @GetMapping("/get2")
    public String get2(){
        String text = "mytext2";
        System.out.println(text);
        int[] data = new int[2];
        data[10]=10;
        return text;
    }

    /*@ExceptionHandler({NullPointerException.class})
    public ResponseEntity<String> nullPointerException(NullPointerException ex, HttpServletRequest request){
        System.out.println("!!!!!!!!!!!!!!!LOCALHandler");
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.OK);
    }*/

}
