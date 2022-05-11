package com.app.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

import static org.junit.Assert.assertTrue;

@Configuration
@EnableJpaRepositories(basePackages = {"com.app.repository"})
public class MyTest4 {

    @Autowired
    private DataSource dataSource;


    @Test
    public void crudTest() {

    }

}

