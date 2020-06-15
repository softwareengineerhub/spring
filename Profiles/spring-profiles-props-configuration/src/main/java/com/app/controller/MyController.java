package com.app.controller;

import com.app.service.Service1;
import com.app.service.Service2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @Autowired(required = false)
    private Service1 service1;
    @Autowired(required = false)
    private Service2 service2;

    @GetMapping("/data")
    public String getData(){
        return "data="+service1.getMessage()+";"+service2.getMessage();
    }
}
