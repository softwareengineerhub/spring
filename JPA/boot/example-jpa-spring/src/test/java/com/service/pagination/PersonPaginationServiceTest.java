/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.pagination;

import com.service.*;
import com.model.Person;
import java.util.List;
import org.junit.Assert;
import static org.junit.Assert.assertTrue;
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
public class PersonPaginationServiceTest {

    @Autowired
    private PersonPaginationService personService;

    @Test
    public void test() {     
        personService.deleteAll();
        
        String name="Name"+System.currentTimeMillis();
        for(int i=0;i<10;i++){
            Person p = new Person(name, i);            
            personService.save(p);
        }
        List<Person> list = personService.doAction(name, 0, 3);
        assertTrue(list.size()==3);
        list.forEach(System.out::println);
        System.out.println("------------------------------------");
        list = personService.doAction2(name, 0, 3);
        assertTrue(list.size()==3);
        list.forEach(System.out::println);
        System.out.println("------------------------------------");
       
    }

}
