package com.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2")
public class SimpleController {

    @GetMapping("/admin")
    public String admin(){
        return "Welcome to admin";
    }

    @GetMapping("/user")
    public String user(){
        return "Welcome to user";
    }

    @GetMapping("/user-admin")
    public String userAdmin(){
        return "Welcome to user-admin";
    }
}
