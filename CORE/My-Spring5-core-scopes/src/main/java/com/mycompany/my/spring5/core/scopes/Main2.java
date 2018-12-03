/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.core.scopes;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main2 {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfig.class);
        MyDog dog1 = (MyDog) ctx.getBean("dog1");
        MyDog dog2 = (MyDog) ctx.getBean("dog2");
        System.out.println(dog1);
        System.out.println(dog2);
        System.out.println("-------------------------");
        dog1 = (MyDog) ctx.getBean("dog1");
        dog2 = (MyDog) ctx.getBean("dog2");
        System.out.println(dog1);
        System.out.println(dog2);
    }

}
