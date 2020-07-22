/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service;

import com.app.model.Person;
import com.app.repository.Dao;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;

/**
 *
 * @author asusadmin
 */
@Service
public class PersonService {
    
    @Inject
    private Dao dao;
    
    public void create(Person person){
        dao.create(person);
    }
    
    public List<Person> findAll(){
        return dao.findAll();
    }
    
    public Person findById(int id){
        return dao.findById(id);
    }
    
    public void update(Person person, int id){
        dao.update(person, id);
    }
    
    public void deleteAll(){
        dao.deleteAll();
    }
    
    public void deleteById(int id){
        dao.delete(id);
    }
    
    
    
}
