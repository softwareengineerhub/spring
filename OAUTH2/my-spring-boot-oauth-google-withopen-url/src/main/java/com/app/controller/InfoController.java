package com.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    @GetMapping("/info")
    public String info(){
        return "info";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
