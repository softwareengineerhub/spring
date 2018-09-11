/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service;

import com.app.controller.PersonController;
import com.app.model.Person;
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
public class PersonControllerTest {
    
    @Autowired
    private PersonController personController;
    
    @Test
    public void test(){
        assertTrue(personController!=null);
        int count=personController.count();
        assertTrue(count==0);
        personController.save(new Person());
        assertTrue(personController.count()==1);
    }

    
}
