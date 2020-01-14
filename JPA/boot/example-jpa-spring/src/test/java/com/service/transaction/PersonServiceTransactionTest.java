/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.transaction;

import com.service.projection.*;
import com.model.Person;
import com.model.projection.SimplePerson;
import com.service.PersonServiceWithRepo3;
import com.service.transactional.PersonServiceTransactions;
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
public class PersonServiceTransactionTest {

    @Autowired
    private PersonServiceTransactions personService;
    
    @Test(expected = RuntimeException.class)
    public void test() {
        personService.removeAll();        
        personService.doSave("TestData");                
    }

}
