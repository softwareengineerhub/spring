/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.app.myannotation;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyPerson {

    private String name;
    private int age;

    public MyPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public MyPerson() {
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
        return "MyPerson{" + "name=" + name + ", age=" + age + '}';
    }

}
