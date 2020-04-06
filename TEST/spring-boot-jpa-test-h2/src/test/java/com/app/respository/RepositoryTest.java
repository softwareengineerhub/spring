package com.app.respository;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.app.config.MySpringConfigTest;
import com.app.model.Customer;
import com.app.repository.CustomerRepository;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author asusadmin
 */
@RunWith(SpringRunner.class)
//@DataJpaTest
@SpringBootTest(classes = {MySpringConfigTest.class})
public class RepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void hello() {
        System.out.println(customerRepository);        
        customerRepository.deleteAll();
        Customer c = new Customer();
        c.setAge(2);
        c.setName("Name2");
        customerRepository.save(c);
        long count = customerRepository.count();
        assertTrue(count == 1);
    }
}
