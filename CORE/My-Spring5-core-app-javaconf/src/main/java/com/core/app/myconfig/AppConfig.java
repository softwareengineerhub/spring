/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.app.myconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 *
 * @author asusadmin
 */
@Configuration
@ComponentScan({"com.core.app.myconfig"})
@PropertySource(value = "classpath:data.properties")
public class AppConfig {
    
    @Bean
    public MyRepository getRepository(){
        return new MyRepositoryImpl();
    }
    
    @Bean(name = "myService")
    public MyService getMyService(){
        MyService myService = new MyServiceImpl(getRepository());
        return myService;
    }
    
}
