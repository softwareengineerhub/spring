package com.app.service;

import javax.annotation.PostConstruct;

public class A {

    @PostConstruct
    public void init(){
        System.out.println("A.init()");
    }
}
