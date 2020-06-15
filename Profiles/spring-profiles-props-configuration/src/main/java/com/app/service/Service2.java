package com.app.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("service2")
public class Service2 {

    public String getMessage(){
        return "Service2.message";
    }
}
