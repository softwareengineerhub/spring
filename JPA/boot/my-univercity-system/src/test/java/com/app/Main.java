package com.app;

import com.app.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ActiveProfiles;

@SpringBootApplication
@EnableJpaRepositories
@ActiveProfiles("test")
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

   /* @Bean
    public DataSource dataSource2() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.jdbc.Driver");
        config.setUsername("root");
        config.setPassword("11111111");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/spring_jpa_data2?useSSL=false");
        return new HikariDataSource(config);
    }*/

}
