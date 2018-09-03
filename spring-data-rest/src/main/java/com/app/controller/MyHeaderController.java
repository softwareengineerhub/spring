/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Denys.Prokopiuk
 */
@RestController
@RequestMapping(value = "/header")
public class MyHeaderController {
    
    @GetMapping(value = "/readheader")
    public void readHeader(@RequestHeader(name = "userName", required = false) String userName){        
        System.out.println("userNameHeader="+userName);
    }
    
}
