package com.app.controller;

import com.app.service.MyUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/update")
public class UpdateController {
    @Autowired
    private MyUpdateService updateService;

    @GetMapping
    public void get(){
        updateService.process();
    }

}
