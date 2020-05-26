/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import com.app.model.Person;
import com.app.model.PersonResponse;
import com.app.repository.PersonRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author asusadmin
 */
@RestController
public class SimpleController {

    @Autowired
    private PersonRepository personRepository;
    
    @PostMapping("/persons")
    public void add(@RequestBody Person person) {
        personRepository.getList().add(person);
    }

    @PostMapping("/persons2")
    public PersonResponse add2(@RequestBody Person person) {
        personRepository.getList().add(person);
        PersonResponse personResponse = new PersonResponse();
        personResponse.setStatus("OK");
        return personResponse;
    }
    
    @PatchMapping("/persons3")
    public PersonResponse update(@RequestBody Person person) {
        int index = personRepository.getList().indexOf(person);
        if(index!=-1){
            
        }
        add(person);
        PersonResponse personResponse = new PersonResponse();
        personResponse.setStatus("OK");
        return personResponse;
    }
    
    @PatchMapping("/persons4")
    public PersonResponse update2(@RequestBody Person person) {
        personRepository.getList().add(person);
        PersonResponse personResponse = new PersonResponse();
        personResponse.setStatus("OK");
        return personResponse;
    }
    
    

    @GetMapping("/persons/{id}")
    public Person getById(@PathVariable int id) {
        return personRepository.getList().get(id);
    }

    @GetMapping("/persons")
    public List<Person> getAll() {
        return personRepository.getList();
    }

}
