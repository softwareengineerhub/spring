/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import com.app.helper.HelperObject;
import com.app.helper.MyHelper;
import com.app.model.Person;
import com.app.repository.PersonRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    @Autowired
    private MyHelper myHelper;
    
    // SPRING WILL NOT START IF THERE IS NO BEAN
    /*@Autowired
    private HelperObject helperObject;
    
    @GetMapping("/helperobject")
    public String getMessageHelperObject() {
        System.out.println(helperObject.getMessage());
        return "SUCCESS"; 
    }*/
    
    @Autowired
    private Optional<HelperObject> helperObject;
    
    @GetMapping("/helperobject")
    public String getMessageHelperObject() {
        helperObject.ifPresent(helperObject->System.out.println(helperObject.getMessage()));
        return "SUCCESS"; 
    }
    
    @GetMapping("/helper")
    public String getMessage() {
        return myHelper.getMessage();
    }

    @PostMapping("/persons")
    public void add(@RequestBody Person person) {
        personRepository.getList().add(person);
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
