package com.app.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class AppConfig {
    @Value("${app.datasource.driver-class-name}")
    private String className;
    @Value("${app.datasource.username}")
    private String username;
    @Value("${app.datasource.password}")
    private String password;
    @Value("${app.datasource.url}")
    private String url;


    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(className);
        config.setUsername(username);
        config.setPassword(password);
        config.setJdbcUrl(url);
        return new HikariDataSource(config);
    }

    /*@Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.jdbc.Driver");
        config.setUsername("root");
        config.setPassword("11111111");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/spring_jpa_data2?useSSL=false");
        return new HikariDataSource(config);
    }*/

}
