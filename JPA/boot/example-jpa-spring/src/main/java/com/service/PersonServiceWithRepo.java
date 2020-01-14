/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.model.Person;
import com.repository.PersonRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author asusadmin
 */
@Service
@Transactional
public class PersonServiceWithRepo {
    
    @Autowired
    private PersonRepository personRepository;
    
    public void setName(Integer id, String name) {
        personRepository.findById(id).ifPresent(p->{p.setName(name);});        
    }

    public Person loadPerson(Integer id) {
        return personRepository.findById(id).orElse(new Person());
    }
    
    public void save(Person person){
        personRepository.save(person);
    }
    
}
