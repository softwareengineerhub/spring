/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.advancedcore.app.initbean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyCat implements InitializingBean {

    @Value("${name}")
    private String name;
    @Value("${age}")
    private int age;

    private String city;

    @Override
    public void afterPropertiesSet() {
        System.out.println("MyCat.afterPropertiesSet(); " + toString());
    }

    public void init() {
        System.out.println("MyCat.init(); " + toString());
    }

   /* public String getName() {
        return name;
    }*/

    public void setName(String name) {
        System.out.println("\tsetName;name="+name);
        this.name = name;
    }

    /*public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }*/

    /*public String getCity() {
        return city;
    }*/

    public void setCity(String city) {
        this.city = city;
    }
    
    
    
    @Override
    public String toString() {
        return "MyCat{" + "name=" + name + ", age=" + age + ", city=" + city + '}';
    }

}
