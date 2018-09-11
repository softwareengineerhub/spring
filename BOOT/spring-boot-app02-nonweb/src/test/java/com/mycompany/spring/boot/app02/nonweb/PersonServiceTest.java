/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring.boot.app02.nonweb;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Denys.Prokopiuk
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @Test
    public void test() {
        assertNotNull(personService);
        assertTrue(personService.count()==0);
    }

}
