/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.advancedcore.app.applicationcontextaware;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author asusadmin
 */
public class Main {
    
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AnnotationConfig.class);
        AnnotationConfigApplicationContext context = (AnnotationConfigApplicationContext) ctx;
      //  context.registerShutdownHook();
        Person person = ctx.getBean(Person.class);
        System.out.println(person);
        
        
    }
    
}
