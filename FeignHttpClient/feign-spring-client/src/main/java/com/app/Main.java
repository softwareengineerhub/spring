/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app;

import com.app.model.Person;
import com.app.model.PersonResource;
import com.mycompany.feign.client.PersonClient;
import feign.Feign;
import feign.Logger;
import feign.Response;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
//import feign.slf4j.Slf4jLogger;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author asusadmin
 */
@SpringBootApplication
public class Main implements CommandLineRunner{
    @Autowired
    private PersonClient personClient;

    public static void main(String[] args) {
        System.setProperty("server.port", "8081");
        SpringApplication.run(Main.class, args);
    }
    
    public void run(String... args) throws Exception {
        PersonResource pr = personClient.findById(0);
        
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
        
        
      //  List<Person> list = personClient.findAll();
       // System.out.println(list.size());
    }

    /*@Override
    public void run(String... args) throws Exception {
        PersonResource pr = personClient.findById(0);
        Person p = pr.getPerson();
        System.out.println(pr);
        System.out.println(p);
                
        p = personClient.findById2(0);
        System.out.println(p);
        
        Person person = new Person("addName", 10);
        personClient.add(person);
        
        List<Person> list = personClient.findAll();
        System.out.println(list);
    }*/

}
