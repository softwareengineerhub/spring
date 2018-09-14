package com.app.main;

import com.app.config.MySecurityConfig;
import com.app.config.MySpringConfig;
import org.springframework.boot.SpringApplication;

public class Main {

    public static void main(String[] args) {
        SpringApplication.run(new Object[]{MySpringConfig.class, MySecurityConfig.class}, args);
    }
}
