/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring.exam.preparation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author asusadmin
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        Person personA = ctx.getBean("a", Person.class);
        Person personB = ctx.getBean("b", Person.class);
        Person personC = ctx.getBean("c", Person.class);
        System.out.println(personA);
        System.out.println(personB);
        System.out.println(personC);
        System.out.println("-------------------------------------");
        Person defaultPerson = ctx.getBean("defaultPerson", Person.class);
        System.out.println(defaultPerson);
    }
    
}
