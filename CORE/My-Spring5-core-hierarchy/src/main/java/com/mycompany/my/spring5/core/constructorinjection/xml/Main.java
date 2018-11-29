/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.core.constructorinjection.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main {
    
    public static void main(String[] args) {
        GenericXmlApplicationContext parent = new GenericXmlApplicationContext();
        parent.load("classpath:parent-context.xml");
        parent.refresh();
        
        GenericXmlApplicationContext child = new GenericXmlApplicationContext();
        child.load("classpath:child-context.xml");
        child.setParent(parent);
        child.refresh();
        
    }
    
}
