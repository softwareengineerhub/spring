/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring.jdbc.smaple;

import java.util.List;

/**
 *
 * @author Denys.Prokopiuk
 */
public interface DAO {
    
    public void save(Person person);
    
    public int count();
    
    public List<Person> getAll();
    
    public List<Person> getAll2();
    
    public void update(String name, Person candidat);
    
}
