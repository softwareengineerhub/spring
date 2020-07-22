/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import com.app.model.Person;
import com.app.repository.Dao;
import com.app.service.PersonService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author asusadmin
 */
@RestController
public class PersonController {
    @Inject
    private PersonService personService;
    
    @PostConstruct
    public void init(){
        Person person = new Person();
        person.setAge(1);
        person.setName("Name1");
        personService.create(person);
        
        person.setAge(11);
        person.setName("Name11");
        personService.update(person, 1);
    }
    
    @GetMapping("/person/{id}")
    public Person findById(@PathVariable int id){
        return personService.findById(id);
    }
    
    @GetMapping("/person")
    public List<Person> findAll(){
        return personService.findAll();
    }
    
    
    
}
