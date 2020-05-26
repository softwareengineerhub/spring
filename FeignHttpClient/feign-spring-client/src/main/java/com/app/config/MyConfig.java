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
import feign.RequestTemplate;
import feign.Response;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import java.io.IOException;
import java.lang.reflect.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author asusadmin
 */
@Configuration
public class MyConfig {
    
    //@Autowired
    //private Enoder encoder;

    @Bean
    public PersonClient personClient() {
        PersonClient personClient = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder(){
            @Override
            public void encode(Object object, Type bodyType, RequestTemplate template) {
                /*System.out.println("@@@@@@@@@@object="+object);
                System.out.println("@@@@@@@@@@bodyType="+bodyType);
                System.out.println("@@@@@@@@@@template="+template);
                System.out.println("@@@@@@@@@@template="+template);
                System.out.println("@@@@@@@@@@template.url="+template.url());
                System.out.println("@@@@@@@@@@template.queryLine="+template.queryLine());
                System.out.println("@@@@@@@@@@template.queries="+template.queries());*/
                
                
                super.encode(object, bodyType, template);
            }
                    
                    
                })
                .decoder(new GsonDecoder(){
            @Override
            public Object decode(Response response, Type type) throws IOException {
                
                System.out.println(response.headers());
               // System.out.println(response);
                //System.out.println(type);
                return super.decode(response, type); //To change body of generated methods, choose Tools | Templates.
            }
                    
                })
                .logger(new Slf4jLogger(PersonClient.class))
                .logLevel(Logger.Level.BASIC)
                .target(PersonClient.class, "http://localhost:8080/");
        return personClient;
    }
    
    
    /*@Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.HEADERS;
    }*/

    @Bean
    public Contract feignContract() {
        return new Contract.Default();
    }

}
