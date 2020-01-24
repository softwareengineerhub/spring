package com.app.controller;

import com.app.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @Autowired
    private MyService myService;

    @GetMapping(value = "/result")
    public String result(){
        return "Hello";
    }

    @GetMapping(value = "/service")
    public String service(){
        return myService.makeAction();
    }

    @GetMapping(value = "/aspect")
    public String aspect(){
        return myService.makeAction();
    }

}
