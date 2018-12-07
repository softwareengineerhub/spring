/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.core.autowired.xml;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyTarget {
    private String name;
    private String secondName;
    private int age;

    public MyTarget(String name, String secondName, int age) {
        this.name = name;
        this.secondName = secondName;
        this.age = age;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "MyTarget{" + "name=" + name + ", secondName=" + secondName + ", age=" + age + '}';
    }
    
    
    
    
}
