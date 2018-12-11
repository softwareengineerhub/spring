/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.advancedcore.app.beannameaware;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author asusadmin
 */
@Component
public class User implements BeanNameAware {
    @Value("${user.name}")
    private String name;
    @Value("${user.age}")
    private int age;
    
    @PostConstruct
    public void init(){
        System.out.println("User.@PostConstruct");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("@@@@@setBeanName;name="+name);
    }

}
