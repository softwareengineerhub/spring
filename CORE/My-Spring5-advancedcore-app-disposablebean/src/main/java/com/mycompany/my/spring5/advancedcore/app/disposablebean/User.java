/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.advancedcore.app.disposablebean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author asusadmin
 */
@Component
public class User implements InitializingBean, DisposableBean {

    @Value("${user.name}")
    private String name;
    @Value("${user.age}")
    private int age;

    @PostConstruct
    public void init() {
        System.out.println("user.@PostConstruct");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("user.afterPropertiesSet()");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("user.destroy()");
    }

    @PreDestroy
    public void myDestroy() {
        System.out.println("user.@PreDestory()");
    }
    
    public void doError(){
        if(1<2){
            throw new RuntimeException("doError()");
        }
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", age=" + age + '}';
    }
    
}
