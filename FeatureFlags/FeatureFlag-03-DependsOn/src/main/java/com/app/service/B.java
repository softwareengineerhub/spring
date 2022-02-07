package com.app.service;

import javax.annotation.PostConstruct;

public class B {

    @PostConstruct
    public void init(){
        System.out.println("B.init()");
    }
}
