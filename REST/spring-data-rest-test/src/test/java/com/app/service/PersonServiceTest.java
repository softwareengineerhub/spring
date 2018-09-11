/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service;

import com.app.config.MyApplicationConfig;
import com.app.config.MySpringConfig;
import com.app.model.Person;
import java.util.ArrayList;
import java.util.List;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Denys.Prokopiuk
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MyTestConfig.class})
public class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @Test
    public void test() {        
        assertNotNull(personService);
        assertTrue(personService.count() == 0);
        Person p0 = new Person();
        p0.setAge(0);
        p0.setName("Name0");
        personService.save(p0);
        assertTrue(personService.count() == 1);
        Person p1 = new Person();
        p1.setAge(1);
        p1.setName("Name1");
        Person p2 = new Person();
        p2.setAge(2);
        p2.setName("Name2");
        List<Person> persons = new ArrayList<>();
        persons.add(p1);
        persons.add(p2);
        personService.saveAll(persons);
        assertTrue(personService.count() == 3);
    }

}
