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
    @Autowired
    private MyService myService;

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
        myService.makeAction();
        System.exit(0);
    }

}
