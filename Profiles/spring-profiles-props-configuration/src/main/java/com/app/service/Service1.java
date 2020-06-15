package com.app.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("service1")
public class Service1 {

    public String getMessage(){
        return "Service1.message";
    }
}
