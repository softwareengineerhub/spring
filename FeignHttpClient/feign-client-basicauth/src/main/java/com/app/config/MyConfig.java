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
import feign.auth.BasicAuthRequestInterceptor;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;

/**
 *
 * @author asusadmin
 */
public class MyConfig {

    public PersonClient personClient(String username, String password) {
        PersonClient personClient = Feign.builder()
                .requestInterceptor(new BasicAuthRequestInterceptor(username, password))
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Logger.JavaLogger())
                .logLevel(Logger.Level.FULL)
                .target(PersonClient.class, "http://localhost:8080/");
        return personClient;
    }

    public Contract feignContract() {
        return new Contract.Default();
    }

}
