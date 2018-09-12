/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.config;

import com.app.service.MyService;
import com.app.service.PersonService;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

/**
 *
 * @author Denys.Prokopiuk
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com"})
@EnableTransactionManagement
public class MySpringConfig implements CommandLineRunner {

    @Autowired
    //@Qualifier(value = "personService")
    //@Qualifier(value = "logService")
    @Qualifier(value = "globalService")
    private MyService myService;
  
    

    @Bean
    public DataSource getPersonDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/person_db");
        dataSource.setUsername("root");
        dataSource.setPassword("111111");
        return dataSource;
    }
    
    @Bean("personTemplate")
    public JdbcTemplate getPersonJdbcTemplateTemaplate() {        
        return new JdbcTemplate(getPersonDataSource());                
    }
    
    @Bean("logTemplate")
    public JdbcTemplate getLogJdbcTemplateTemaplate() {        
        /*JdbcTemplate template = new JdbcTemplate();        
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/log_db");
        dataSource.setUsername("root");
        dataSource.setPassword("111111");        
        template.setDataSource(dataSource);
        return template;*/
        return new JdbcTemplate(getPersonDataSource());                
    }

    @Override
    public void run(String... strings) throws Exception {
        myService.makeAction();
        System.exit(0);
    }

}
