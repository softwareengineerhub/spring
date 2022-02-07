package com.app.service;

import javax.annotation.PostConstruct;

public class BooksDefaultService implements BooksService {

    @PostConstruct
    public void init(){
        System.out.println("BooksDefaultService.init()");
    }

    @Override
    public String getBooksResult() {
        return "Default books implementation";
    }
}
