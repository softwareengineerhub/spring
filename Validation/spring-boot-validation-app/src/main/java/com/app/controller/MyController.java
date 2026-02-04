package com.app.controller;

import com.app.domain.Person;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.List;

@RestController
public class MyController {

    @GetMapping("/my")
    public String findAll(@RequestHeader(value = "If-Modified-Since", required = false) String val ) {
        try {
            return "val=" + val;
        }catch (Exception ex){
            return ex.getMessage();
        }
    }

    @GetMapping("/his")
    public String findAll2(@RequestHeader(value = "If-Modified-Since", required = false) Instant val ) {
        try {
            return "val=" + val;
        }catch (Exception ex){
            return ex.getMessage();
        }
    }

}
