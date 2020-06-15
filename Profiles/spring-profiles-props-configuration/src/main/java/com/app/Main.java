package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {

        System.setProperty("spring.profiles.active", "service1,service2");
        SpringApplication.run(Main.class, args);
    }
}
