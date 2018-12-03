/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.core.bean.names.javaconfig;

import java.util.Arrays;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main2 {

    public static void main(String[] args) {
        
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfig.class);
        String[] names = ctx.getBeanDefinitionNames();
        System.out.println(Arrays.toString(names));
        MyCat myCat = (MyCat) ctx.getBean("getCat");
        System.out.println(myCat);
        MyCat myCat2 = (MyCat) ctx.getBean("myCat");
        System.out.println(myCat2);        
        System.out.println("-------------------------------------------------");
        // @Bean(name = {"a", "b", "c"}, value = {"val1", "val2", "val3"}, initMethod = "myInit", destroyMethod = "myDestroy")
        MyDog myDog = (MyDog) ctx.getBean("a");
        System.out.println(myDog);
        myDog = (MyDog) ctx.getBean("b");
        System.out.println(myDog);
        myDog = (MyDog) ctx.getBean("c");
        System.out.println(myDog);       
        System.out.println("-------------------------------------------------");
        MyDog myDog1 = (MyDog) ctx.getBean("val1");
        System.out.println(myDog1);
        myDog1 = (MyDog) ctx.getBean("val2");
        System.out.println(myDog1);
        myDog1 = (MyDog) ctx.getBean("val3");
        System.out.println(myDog1);
    }
    
}
