package com.app.controller;

import com.app.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@Transactional
public class MyController {

    @Autowired
    private MyService myService;

    @GetMapping("/action")
    public void doAction(){
        myService.process();
    }

}
