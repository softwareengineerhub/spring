package com.app.controller;

import com.app.configuration.properties.MyTaskProperties;
import com.app.configuration.properties.OpenidProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyTaskController {

    @Autowired
    private MyTaskProperties myTaskProperties;

    @GetMapping("/mytask")
    public String getData(){
        String mySubject = myTaskProperties.getMailSubject();
        System.out.println("mySubhect="+mySubject);
        return mySubject;
    }
}
