/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.core.scopes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author Denys.Prokopiuk
 */
@Configuration
public class MyConfig {

    @Bean(value="dog1")
    @Scope(value = "singleton")
    public MyDog getDog(){
        return new MyDog();
    }
    
    @Bean(value="dog2")
    @Scope(value = "prototype")
    public MyDog getDog2(){
        return new MyDog();
    }
    
}
