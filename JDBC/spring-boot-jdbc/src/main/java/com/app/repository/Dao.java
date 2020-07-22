/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.repository;

import com.app.model.Person;
import java.util.List;

/**
 *
 * @author asusadmin
 */
public interface Dao {

    public void create(Person person);
    
    public List<Person> findAll();
    
    public Person findById(int id);
    
    public void update(Person person, int id);
    
    public void deleteAll();
    
    public void delete(int id);
}
