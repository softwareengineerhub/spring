package com.app.controller;

import com.app.configuration.properties.OpenidProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @Autowired
    private OpenidProperties openidProperties;
    @Autowired
    private Environment environment;

    @GetMapping("/data")
    public String getData(){
        System.out.println("env="+environment.getProperty("my.openid.ui-client-id"));
        System.out.println("env2="+System.getenv("my.openid.ui-client-id"));

        return "data="+openidProperties.getUiClientId()+";"+openidProperties.getUiClientId2();
    }
}
