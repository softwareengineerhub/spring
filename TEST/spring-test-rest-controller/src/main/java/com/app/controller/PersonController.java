/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import com.app.model.Person;
import com.app.repository.PersonRepository;
import java.util.List;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author asusadmin
 */
@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;
    
    @GetMapping("/persons/size")
    public String getSize() {
        return personRepository.findAll().size()+"";
    }

    @GetMapping("/persons/all")
    //@PreAuthorize
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @PostMapping("/persons/add")
    public void add(@RequestBody Person person) {
        personRepository.add(person);
    }
    
    

}
