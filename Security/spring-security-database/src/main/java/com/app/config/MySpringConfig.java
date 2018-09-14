package com.app.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

//@EnableWebMvc
@SpringBootApplication
@ComponentScan(basePackages = {"com"})
public class MySpringConfig {

    @Bean
    public DataSource getDataSource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setUsername("fs4_user");
        ds.setPassword("caPEtown");
        ds.setUrl("jdbc:mysql://danit.cukm9c6zpjo8.us-west-2.rds.amazonaws.com:3306/fs4");
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        return ds;
    }

}
