/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.model.Person;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author asusadmin
 */

@Transactional
@Component
public class PersonService {

    @Autowired
    private EntityManager em;

    public void setName(Integer id, String name) {
        Person person = em.find(Person.class, id);
        person.setName(name);
    }

    public Person loadPerson(Integer id) {
        return em.find(Person.class, id);
    }
    
    public void save(Person person){
        em.persist(person);
    }
    
}
