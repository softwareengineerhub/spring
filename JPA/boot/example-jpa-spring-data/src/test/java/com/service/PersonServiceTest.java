/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.TestAppConfig;
import com.config.AppConfig;
import com.model.Person;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author asusadmin
 */
@SpringBootTest
@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = {TestAppConfig.class})
//@Import(AppConfig.class)
public class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @Test
    public void test() {
        System.out.println(personService);
        Person p = new Person("Name", 1);
        personService.save(p);        
        personService.setName(p.getId(), "TestName"+p.getId());
        Person person = personService.loadPerson(p.getId());
        Assert.assertEquals("TestName"+p.getId(), person.getName());
    }

}
