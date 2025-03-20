package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@SpringBootApplication
@EnableJpaRepositories
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AppStarter {

    public static void main(String[] args) {
       // NoOpPasswordEncoder.getInstance();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = encoder.encode("11111111");
        System.out.println("password="+password);


        SpringApplication.run(AppStarter.class, args);
    }

}
