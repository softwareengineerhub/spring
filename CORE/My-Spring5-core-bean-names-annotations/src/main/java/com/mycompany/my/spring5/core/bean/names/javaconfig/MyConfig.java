/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.core.bean.names.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Denys.Prokopiuk
 */
@Configuration
public class MyConfig {
    
   
    
    @Bean
    public MyCat getCat(){
        return new MyCat();
    }
    
    @Bean(name = "myCat")
    public MyCat getCat2(){
        return new MyCat();
    }
    
    @Bean
    public MyDog getDog(){
        return new MyDog();
    } 
    
    @Bean(name = {"a", "b", "c"}, initMethod = "myInit", destroyMethod = "myDestroy")
    public MyDog getDog2(){
        MyDog myDog = new MyDog();
        myDog.setName("abc");
        return myDog;
    }
    
    @Bean(value = {"val1", "val2", "val3"}, initMethod = "myInit", destroyMethod = "myDestroy")
    public MyDog getDog3(){
        MyDog myDog = new MyDog();
        myDog.setName("val123");
        return myDog;
    }
    
}
