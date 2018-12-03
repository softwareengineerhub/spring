/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.core.scopes;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main {
    
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyCar myCar = (MyCar) ctx.getBean("myCar1");
        System.out.println(myCar);
        MyCar myCar2 = (MyCar) ctx.getBean("myCar2");
        System.out.println(myCar2);
        System.out.println("-----------------------");
        myCar = (MyCar) ctx.getBean("myCar1");
        System.out.println(myCar);
        myCar2 = (MyCar) ctx.getBean("myCar2");
        System.out.println(myCar2);
        System.out.println("---------Annotations--------------");
        MyPerson myPerson = (MyPerson) ctx.getBean("myPerson");
        MyPerson2 myPerson2 = (MyPerson2) ctx.getBean("p2");
        System.out.println(myPerson);
        System.out.println(myPerson2);
        System.out.println("-----------------------");
        myPerson = (MyPerson) ctx.getBean("myPerson");
        myPerson2 = (MyPerson2) ctx.getBean("p2");
        System.out.println(myPerson);
        System.out.println(myPerson2);
        
    }
    
}
