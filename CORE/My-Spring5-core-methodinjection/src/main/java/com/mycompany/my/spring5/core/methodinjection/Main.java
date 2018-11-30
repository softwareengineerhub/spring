/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.core.methodinjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main {
    
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("app-config.xml");
        DemoBean a = (DemoBean) ctx.getBean("abstractLookupBean");
        DemoBean b = (DemoBean) ctx.getBean("standardLookupBean");
        a.doSomething();
        b.doSomething();
    }
    
}
