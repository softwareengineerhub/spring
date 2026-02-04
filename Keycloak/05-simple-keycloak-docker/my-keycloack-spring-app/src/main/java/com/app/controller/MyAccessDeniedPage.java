package com.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/access-denied")
public class MyAccessDeniedPage {

    @GetMapping
    public String get(){
        return "You do not have permissions";
    }
}
