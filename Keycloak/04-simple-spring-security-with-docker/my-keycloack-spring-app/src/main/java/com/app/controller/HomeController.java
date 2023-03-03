package com.app.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {
    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @GetMapping
    public String get(){
        System.out.println("##########driverClassName="+driverClassName);
        return "/home-SUCCESS; "+driverClassName;
    }

}
