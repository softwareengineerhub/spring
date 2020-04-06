/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import com.app.model.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author asusadmin
 */
@RestController
public class HelloWorldController {
    
    @GetMapping("/hello/world")
    public String getMessage(){
        return "HelloWorld";
    }
    
    
    @GetMapping("/hello/customer")
    public Customer getCustomer(){
        Customer customer = new Customer();
        customer.setAge(1);
        customer.setId(1L);
        customer.setName("Name1");
        return customer;
    }
    
}
