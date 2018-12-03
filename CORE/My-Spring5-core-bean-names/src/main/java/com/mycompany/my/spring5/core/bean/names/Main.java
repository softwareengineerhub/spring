/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.core.bean.names;

import java.util.Arrays;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main {
    
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyDog myDog1 = (MyDog) ctx.getBean("myDog1");
        System.out.println(myDog1);
        MyDog myDog2 = (MyDog) ctx.getBean("myDog2");
        System.out.println(myDog2);
        MyDog myDog3Name = (MyDog) ctx.getBean("myDog3Name");
        System.out.println(myDog3Name);
        MyDog myDog3Id = (MyDog) ctx.getBean("myDog3Id");
        System.out.println(myDog3Id);        
        String[] names = ctx.getBeanDefinitionNames();
        System.out.println(Arrays.toString(names));
        MyCat myCat = (MyCat) ctx.getBean("com.mycompany.my.spring5.core.bean.names.MyCat#0");
        System.out.println(myCat);        
        
    }
    
    
    
}
