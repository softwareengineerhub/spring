/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.advancedcore.app.xml;

import org.springframework.beans.factory.annotation.Value;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyData {

    @Value("${name}")
    private String name;
    @Value("${age}")
    private int age;

    public MyData() {
        System.out.println("MyData.constructor(); name=" + name + "; age=" + age);
    }
    
    public void init() {
        System.out.println("MyData.init(); name=" + name + "; age=" + age);
    }

    public final String init2() throws Exception {
        System.out.println("MyData.init2(); name=" + name + "; age=" + age);;
        return "init2";
    }

}
