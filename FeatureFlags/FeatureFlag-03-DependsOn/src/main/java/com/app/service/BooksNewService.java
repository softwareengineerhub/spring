package com.app.service;

import javax.annotation.PostConstruct;

public class BooksNewService implements BooksService {

    @PostConstruct
    public void init(){
        System.out.println("BooksNewService.init()");
    }

    @Override
    public String getBooksResult() {
        return "New books implementation";
    }
}
