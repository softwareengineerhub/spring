/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.model.Person;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author asusadmin
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class PersonServiceWithRepo2Test {

    @Autowired
    private PersonServiceWithRepo2 personService;

    @Test
    public void test() {
        System.out.println(personService);
        Person p = new Person("Name", 1);
        personService.save(p);
        
        personService.setName(p.getId(), "TestName"+p.getId());
        Person person = personService.loadPerson(p.getId());
        Assert.assertEquals("TestName"+p.getId(), person.getName());
        
        
    }
    
    @Test
    public void test2() {        
        String name = "Name"+System.currentTimeMillis();
        Person p = new Person(name, 1);
        personService.save(p);
        p = new Person(name, 1);
        personService.save(p);
        
        List<Person> list = personService.findByName(name);        
        Assert.assertTrue(list.size()==2);
        
        
    }

}
