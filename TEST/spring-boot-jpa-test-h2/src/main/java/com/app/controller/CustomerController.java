/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import com.app.model.Customer;
import com.app.service.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Denys.Prokopiuk
 */
@RestController
@Transactional
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/count", method = {RequestMethod.GET}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public long count() {
        return customerService.count();
    }

    @RequestMapping(value = "/get/{id}", method = {RequestMethod.GET}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Customer get(@PathVariable("id") long id) {
        return customerService.get(id);
    }

    @GetMapping(value = "/getall")
    public List<Customer> getAll() {
        return customerService.getAll();
    }

    @PostMapping(value = "/save")
    public void save(@RequestBody Customer customer) {
        customerService.save(customer);
    }

    @PostMapping(value = "/saveall")
    public void saveAll(@RequestBody List<Customer> customers) {
        customerService.saveAll(customers);
    }

    @PutMapping(value = "/update/{id}")
    public void update(@PathVariable("id") long id, @RequestBody Customer customer) {
        customerService.update(id, customer);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void remove(@PathVariable("id") long id) {
        customerService.remove(id);
    }

    @DeleteMapping(value = "/deleteall")
    public void removeAll() {
        customerService.removeAll();
    }

}
