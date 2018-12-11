/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.advancedcore.app.disposablebean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author asusadmin
 */
public class Main {

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        User user = ctx.getBean(User.class);
        System.out.println(user);
        System.out.println(user.hashCode());
        try {
            user.doError();
        } catch (Exception ex) {

        }
        
        user.destroy();
        
        user = ctx.getBean(User.class);
        System.out.println(user);
        System.out.println(user.hashCode());
        
        
        AnnotationConfigApplicationContext context = (AnnotationConfigApplicationContext) ctx;
        context.close();
        //ctx=null;
        
       // Thread.sleep(20000);
       
       
    }

}
