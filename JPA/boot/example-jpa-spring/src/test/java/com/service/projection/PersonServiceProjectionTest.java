/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.projection;

import com.model.Person;
import com.model.projection.SimplePerson;
import com.repository.projection.PersonRepositoryProjection;
import com.service.PersonServiceWithRepo3;
import com.service.pagination.PersonPaginationService;
import java.util.List;
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
public class PersonServiceProjectionTest {

    @Autowired
    private PersonServiceProjection personService;
    @Autowired
    private PersonServiceWithRepo3 personServiceWithRepo3;

    @Test
    public void test() {
        String name = "Name" + System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            Person p = new Person(name, i);
            personServiceWithRepo3.save(p);
        }

        List<SimplePerson> list = personService.findSimpleByFirstName(name);
        assertTrue(list.size() == 5);

        for(SimplePerson sp: list){
            System.out.println(sp.getAge());
            System.out.println(sp.getName());            
            System.out.println("---------");
        }

    }

}
