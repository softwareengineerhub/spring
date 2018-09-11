/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import com.app.model.Person;
import com.app.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Denys.Prokopiuk
 */
@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(value = "/count")
    public int count() {
        return personService.count();
    }
    
    @PostMapping(value = "/save")
    public void save(Person person) {
        personService.save(person);
    }
    
}
