/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.core.bean.names;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyCat {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyCat{" + "name=" + name + '}';
    }
    
    
}
