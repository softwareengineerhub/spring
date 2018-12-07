/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.core.autowired.xml2;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyService {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyService{" + "name=" + name + '}';
    }
    
    

}
