/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.core.inheritance;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Animal {
    private String title;
    
    public void makeSound(){
        System.out.println("animal.makeSound().title="+title);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    
    
    
    
}
