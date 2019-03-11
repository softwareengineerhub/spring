/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring.exam.preparation;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author asusadmin
 */
@Configuration
@ComponentScan(basePackages = {"com.mycompany"})
public class AppConfig {

    @Bean(name = "a")
    public Person getPersonA() {
        System.out.println("\tconfig.a");
        Person p = new Person();
        p.setName("A");
        p.setAge(1);
        return p;
    }

    @Bean(name = "b")
    public Person getPersonB() {
        System.out.println("\tconfig.b");
        Person p = new Person();
        p.setName("B");
        p.setAge(2);
        return p;
    }

    @Bean(name = "c")
    public Person getPersonC() {
        System.out.println("\tconfig.c");
        Person p = new Person();
        p.setName("C");
        p.setAge(3);
        return p;
    }

    @Bean
    public BeanFactoryPostProcessor getBeanFactoryPostProcessor() {
        return new MyBeanFactoryPostProcessor();
    }
    
     @Bean
    public BeanFactoryPostProcessor getBeanFactoryPostProcessor2() {
        return new MyBeanFactoryPostProcessor2();
    }

    @Bean
    public BeanPostProcessor getBeanPostProcessor() {
        return new MyBeanPostProcessor();
    }
    
    @Bean
    public BeanPostProcessor getBeanPostProcessor2() {
        return new MyBeanPostProcessor2();
    }

}
