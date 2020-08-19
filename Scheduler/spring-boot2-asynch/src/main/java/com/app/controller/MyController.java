package com.app.controller;

import com.app.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
public class MyController {
    @Autowired
    private MyService myService;

    @GetMapping("/getdata")
    public String getData() throws ExecutionException, InterruptedException {
        Future<String> res = myService.calculateMessage();
        return res.get();
    }


}
