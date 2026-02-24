package com.denistech.jwt.api;

import com.denistech.jwt.api.util.JwtUtil;
import com.denistech.jwt.api.util.JwtUtil02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecutirtyGwtExampleApplication implements CommandLineRunner {

    public static void main(String[] args) {
        System.setProperty("server.port","9192");
        SpringApplication.run(SpringSecutirtyGwtExampleApplication.class, args);
    }

    @Autowired
    private JwtUtil02 util02;
    @Autowired
    private JwtUtil util;
    @Override
    public void run(String... args) throws Exception {
        //String token = util.generateToken("TEST", "QQQQQQQQQ", "USER");
        //f(x,y)-->token
        //header.body.signature
        //eyJhbGciOiJIUzI1NiJ9.eyJwYXNzd29yZCI6IjEiLCJzdWIiOiJ1MSIsImlhdCI6MTc3MTk0NjgwMiwiZXhwIjoxNzcxOTQ2ODYyfQ.2_eeKJ40osTwJOV5WWYQ2rphqOwty_gm0VkpKs8rzTo
        //System.out.println(token);

        String token = "eyJhbGciOiJIUzUxMiJ9.eyJwYXNzd29yZCI6IlFRUVFRUVFRUSIsInJvbGUiOiJVU0VSIiwic3ViIjoiVEVTVCIsImlhdCI6MTc3MTk1MzE3OCwiZXhwIjoxNzcxOTUzMjM4fQ.PD5eGlRKPS0krlP_eAHN_dVRU7GYPUMAw53mujnWZg4dePxg-BVfdsGJ-RyC_jlvqzNaSqKDuTFWFA4MnI7iYg";
        String username = util.extractUsername(token);
        System.out.println("username="+username);

    }
}
