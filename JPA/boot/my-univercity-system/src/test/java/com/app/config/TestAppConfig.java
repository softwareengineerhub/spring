package com.app.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

@Configuration
@Profile("test")
public class TestAppConfig {

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.jdbc.Driver");
        config.setUsername("root");
        config.setPassword("11111111");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/qqq?useSSL=false");
        return new HikariDataSource(config);
    }



    /*@Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.h2.Driver");
        config.setUsername("sa");
        config.setPassword("sa");
        config.setJdbcUrl("jdbc:h2:mem:db;DB_CLOSE_DELAY=-1");
        return new HikariDataSource(config);
    }*/



}
