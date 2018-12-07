/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.advancedcore.app.initbeanjavaconf;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyCar {

    private String name;
    private int year;
    
    public void init(){
        System.out.println("init()");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "MyCar{" + "name=" + name + ", year=" + year + '}';
    }

}
