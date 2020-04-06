package com.app.service;

import org.springframework.stereotype.Service;

@Service
public class SimpleService {

    public String getContent(){
        return "DefaultContent";
    }

}
