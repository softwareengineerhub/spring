/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.core.bean.names.javaconfig;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyDog {
    private String name;
 
    public void myInit(){
        System.out.println("init()");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void myDestroy(){
        System.out.println("destory()");
    }

    @Override
    public String toString() {
        return "MyDog{" + "name=" + name + '}';
    }
    
}
