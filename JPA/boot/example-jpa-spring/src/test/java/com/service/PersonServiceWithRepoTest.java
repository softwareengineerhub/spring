/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.model.Person;
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
public class PersonServiceWithRepoTest {

    @Autowired
    private PersonServiceWithRepo personService2;

    @Test
    public void test() {
        System.out.println(personService2);
        Person p = new Person("Name", 1);
        personService2.save(p);
        
        personService2.setName(p.getId(), "TestName"+p.getId());
        Person person = personService2.loadPerson(p.getId());
        Assert.assertEquals("TestName"+p.getId(), person.getName());
    }

}
