/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import com.app.model.Person;
import com.app.service.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
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
//import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Denys.Prokopiuk
 */
@RestController
public class PersonController {

    @Autowired
    @Qualifier(value = "personServiceRepo")
    private PersonService personService;

    @RequestMapping(value = "/count", method = {RequestMethod.GET}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public long count() {
        return personService.count();
    }

    @RequestMapping(value = "/get/{id}", method = {RequestMethod.GET}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Person get(@PathVariable("id") int id) {
        return personService.get(id);
    }

    @GetMapping(value = "/getall")
    public List<Person> getAll() {
        return personService.getAll();
    }

    @PostMapping(value = "/save")
    public void save(@RequestBody Person person) {
        personService.save(person);
    }

    @PostMapping(value = "/saveall")
    public void saveAll(@RequestBody List<Person> persons) {
        personService.saveAll(persons);
    }

    @PutMapping(value = "/update/{id}")
    public void update(@PathVariable("id") int id, @RequestBody Person candidat) {
        personService.update(id, candidat);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void remove(@PathVariable("id") int id) {
        personService.remove(id);
    }

    @DeleteMapping(value = "/deleteall")
    public void removeAll() {
        personService.removeAll();
    }

}
