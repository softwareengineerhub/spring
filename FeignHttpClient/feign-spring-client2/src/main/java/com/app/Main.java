/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app;

import com.app.config.PersonClient;
import com.app.model.Person;
import feign.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.util.List;

//import feign.slf4j.Slf4jLogger;

/**
 *
 * @author asusadmin
 */
@SpringBootApplication
public class Main implements CommandLineRunner{
    @Autowired
    private PersonClient personClient;

    public static void main(String[] args) {
        System.setProperty("server.port", "8082");
        SpringApplication.run(Main.class, args);
    }
    
    public void run(String... args) throws Exception {
        //PersonResource pr = personClient.findById(0);
        //System.out.println(pr);

        Person person = new Person("addName", 10);
        Response response =  personClient.add(person);
        
        System.out.println("------------response------------");
        System.out.println(response.headers());
        System.out.println("------------response------------");
        
        System.out.println("------------response.body------------");
        BufferedReader reader = new BufferedReader(response.body().asReader());
        String line = null;
        StringBuilder sb = new StringBuilder();
        while((line = reader.readLine())!=null){
            sb.append(line);
        }
        System.out.println(sb);
        System.out.println("------------response.body------------");
        
        System.out.println("------------response.status------------");        
        System.out.println(response.status());
        System.out.println("------------response.status------------");
        
        List<Person> list = personClient.findAll();
        System.out.println(list.size());
    }

}
