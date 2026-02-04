package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        System.setProperty("server.port", "8085");
        SpringApplication.run(Main.class, args);
    }
}
