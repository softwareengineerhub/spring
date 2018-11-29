/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.core.injection.latest;

import com.mycompany.my.spring5.core.injection.latest.ee.MyServiceB;
import com.mycompany.my.spring5.core.injection.latest.resource.MyServiceC;
import com.mycompany.my.spring5.core.injection.latest.resource.MyServiceC2;
import com.mycompany.my.spring5.core.injection.latest.spring.MyServiceA;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main {
    
    public static void main(String[] args) {        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyService myServiceA = (MyServiceA) ctx.getBean("myServiceA");
        myServiceA.doAction();
        System.out.println("------------------");
        MyService myServiceB = (MyServiceB) ctx.getBean("myServiceB");
        myServiceB.doAction();
        System.out.println("------------------");
        MyService myServiceC = (MyServiceC) ctx.getBean("myServiceC");
        myServiceC.doAction();
        System.out.println("------------------");
        MyService myServiceC3 = (MyServiceC2) ctx.getBean("myServiceC2");
        myServiceC3.doAction();
    }
    
}
