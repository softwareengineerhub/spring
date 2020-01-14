/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.repository;

import com.model.Person;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author asusadmin
 */
public interface PersonRepository3 extends JpaRepository<Person, Integer> {

    List<Person> findByName(String name);
    
    //@Query("SELECT p.name FROM Person p WHERE p.age=#age")
    //@Query("SELECT p.name FROM Person p ")
    
    @Query("SELECT p.name FROM Person p WHERE p.age=:age")
    public List<String> namesByAge(@Param("age") int age);
    
}
