/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.model.Person;
import com.repository.PersonRepository;
import com.repository.PersonRepository2;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author asusadmin
 */
@Service
@Transactional
public class PersonServiceWithRepo2 {
    
    @Autowired
    private PersonRepository2 personRepository2;
    
    public void setName(Integer id, String name) {
        personRepository2.findById(id).ifPresent(p->{p.setName(name);});        
    }

    public Person loadPerson(Integer id) {
        return personRepository2.findById(id).orElse(new Person());
    }
    
    public void save(Person person){
        personRepository2.save(person);
    }
    
    public List<Person> findByName(String name){
        return personRepository2.findByName(name);
    }
    
}
