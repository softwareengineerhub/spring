/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring.jdbc.smaple;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import java.util.List;

/**
 *
 * @author Denys.Prokopiuk
 */
@SpringBootApplication
public class MySpringConfig implements CommandLineRunner {

    @Autowired
    private DAO dao;

    @Bean("a")
    public MyProcessor processorA() {
        return new MyProcessor() {
            @Override
            public void process() {
                System.out.println("ProcessorA");
            }
        };
    }

    @Bean("b")
    public MyProcessor processorB() {
        return new MyProcessor() {
            @Override
            public void process() {
                System.out.println("ProcessorB");
            }
        };
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/testdb");
        dataSource.setUsername("root");
        dataSource.setPassword("111111");
        return dataSource;
    }

    @Bean
    public JdbcTemplate getJdbcTemplateTemaplate() {
        DataSource ds = getDataSource();
        return new JdbcTemplate(ds);
    }

    @Override
    public void run(String... strings) throws Exception {
        int count = dao.count();
        System.out.println("count=" + count);
        System.out.println("--------------------------");
        List<Person> persons = dao.getAll();
        for (Person p : persons) {
            System.out.println(p);
        }
        System.out.println("--------------------------");
        Person p = new Person();
        p.setAge(1);
        p.setName("Name1");
        dao.save(p);
        System.out.println("count=" + dao.count());
        System.exit(0);
    }

}
