package com.denistech.jwt.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecutirtyGwtExampleApplication {

    public static void main(String[] args) {
        System.setProperty("server.port","9192");
        SpringApplication.run(SpringSecutirtyGwtExampleApplication.class, args);
    }

}
