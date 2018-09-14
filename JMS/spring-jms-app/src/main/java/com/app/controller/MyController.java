/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import com.app.producer.MessasgeProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Denys.Prokopiuk
 */
@RestController
public class MyController {
    @Autowired
    private MessasgeProducer producer;
    
    @GetMapping(value = "/sent/{message}")
    public void send(@PathVariable("message") String message){
        System.out.println("@BEFORE");
        producer.sendMessage(message);
        System.out.println("@AFTER");
    }
    
}
