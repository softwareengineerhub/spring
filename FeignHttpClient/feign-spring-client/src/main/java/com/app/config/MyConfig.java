/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.config;

import com.mycompany.feign.client.PersonClient;
import feign.Contract;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author asusadmin
 */
@Configuration
public class MyConfig {

    @Bean
    public PersonClient personClient() {
        PersonClient personClient = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(PersonClient.class))
                .logLevel(Logger.Level.FULL)
                .target(PersonClient.class, "http://localhost:8080/");
        return personClient;
    }

    @Bean
    public Contract feignContract() {
        return new Contract.Default();
    }

}
