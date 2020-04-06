package com.app.respository;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.app.config.MySpringConfig;
import com.app.model.Customer;
import com.app.repository.CustomerRepository;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author asusadmin
 */


// uses H2 by default in case of @DataJpaTest
//2020-03-28 18:44:47.509  INFO 15068 --- [           main] o.s.j.d.e.EmbeddedDatabaseFactory        : Starting embedded database: url='jdbc:h2:mem:29418ba7-110d-4a14-bdcd-0218f65fb3dd;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=false', username='sa'

@RunWith(SpringRunner.class)
@DataJpaTest
//@SpringBootTest
@SpringBootTest(classes = {MySpringConfig.class})
public class RepositoryTest2 {

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
