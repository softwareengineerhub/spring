/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.config;

import feign.Client;
import feign.Contract;
import feign.Feign;
import feign.codec.Decoder;
import feign.codec.Encoder;
//import org.apache.http.client.HttpClient;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 *
 * @author asusadmin
 */
@Configuration
//@EnableFeignClients
@Import(FeignClientsConfiguration.class)
//@ComponentScan(basePackages = "com")
public class MyConfig {

    @Bean
    public PersonClient personClient(Client client, Decoder decoder, Encoder encoder, Contract contract){
        //clinet=feign.httpclient.ApacheHttpClient@44aed6a4
        return Feign.builder().client(client)
                .encoder(encoder)
                .decoder(decoder)
                .contract(contract)
                .target(PersonClient.class, "http://localhost:8080/");
    }

    /*@Bean
    public Client client(){
        new TracingClient(new ApacheHttpClient(HttpClientBuilder.create().build());
        new ApacheHttpClient(HttpClientBuilder.create().build());
       // return new ApacheHttpClient();
    }*/

    /*@Bean
    public Decoder decoder(){
        return new Decoder.Default();
    }

    @Bean
    public Encoder encoder(){
        return new Encoder.Default();
    }

    @Bean
    public Contract contract() {
        return new Contract.Default();
    }*/

}
