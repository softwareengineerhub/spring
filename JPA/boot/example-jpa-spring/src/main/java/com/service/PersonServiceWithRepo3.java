/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.model.Person;
import com.repository.PersonRepository;
import com.repository.PersonRepository2;
import com.repository.PersonRepository3;
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
public class PersonServiceWithRepo3 {
    
    @Autowired
    private PersonRepository3 personRepository;
    
    public void setName(Integer id, String name) {
        personRepository.findById(id).ifPresent(p->{p.setName(name);});        
    }

    public Person loadPerson(Integer id) {
        return personRepository.findById(id).orElse(new Person());
    }
    
    public void save(Person person){
        personRepository.save(person);
    }
    
    public List<Person> findByName(String name){
        return personRepository.findByName(name);
    }
    
    public List<String> namesByAge(int age){
        return personRepository.namesByAge(age);
    }
    
}
