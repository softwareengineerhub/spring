/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.DriverManager;
import javax.sql.DataSource;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 *
 * @author Denys.Prokopiuk
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com"})
@EnableJpaRepositories("com")
@EntityScan("com")
public class MySpringConfigTest {

    @Bean
    public DataSource getDataSource() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.h2.Driver");
        config.setUsername("sa");
        config.setPassword("");
        config.setJdbcUrl("jdbc:h2:file:E:/Soft/h2/personsdb.db");
        config.setConnectionTimeout(60000);
        config.setMaximumPoolSize(5);
        return new HikariDataSource(config);
    }

}
