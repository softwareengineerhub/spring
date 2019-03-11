/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring.exam.preparation;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.InitializingBean;

/**
 *
 * @author asusadmin
 */
public class Person implements InitializingBean {
    private String name;
    private int age;
    
    @PostConstruct
    public void init(){
        System.out.println("\t\t\t@PostConstruct: "+name);
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
    public String toString() {
        return "Person{" + "name=" + name + ", age=" + age + '}';
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("\t\t\t\tafterPropertiesSet()");
    }
    
    
}
