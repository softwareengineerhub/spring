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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 *
 * @author asusadmin
 */
@Configuration
@Import(FeignClientsConfiguration.class)
public class MyConfig {


    @Bean
    public SFClient sfClient(Client client, Decoder decoder, Encoder encoder, Contract contract, SFTokenProvider sfTokenProvider){
        return Feign.builder().client(client)
                .encoder(encoder)
                .decoder(decoder)
                .contract(contract)
                .requestInterceptor(new MyAuthInterceptor())
                .target(SFClient.class, "https://eu31.salesforce.com/");
    }

    @Bean
    public SFTokenProvider sfTokenProvider(){
        return new SFTokenProvider();
    }

}
