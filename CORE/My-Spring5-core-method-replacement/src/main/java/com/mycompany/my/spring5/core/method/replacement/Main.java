/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.core.method.replacement;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main {
    
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("app-config.xml");
        ReplacementTarget bean = (ReplacementTarget) ctx.getBean("standardTarget");
        System.out.println(bean.formatMessage("String fromat"));
        System.out.println(bean.formatMessage(new Object()));
        
        System.out.println("------------------------------------------------");
        
        bean = (ReplacementTarget) ctx.getBean("myTarget");
        System.out.println(bean.formatMessage("String fromat"));
        System.out.println(bean.formatMessage(new Object()));
    }
    
}
