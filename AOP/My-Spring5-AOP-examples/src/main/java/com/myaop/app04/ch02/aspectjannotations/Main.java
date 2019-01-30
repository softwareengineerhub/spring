/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myaop.app04.ch02.aspectjannotations;

import com.myaop.app02.pointcut.ch02.simplenamematching.Guitar;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main {
    
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/com/myaop/app04/ch02/aspectjannotations/appConfig.xml");
        MyPersonCh02 personCh02 = ctx.getBean(MyPersonCh02.class);
       // Guitar value = new Guitar();
        //personCh02.sing(value);
    }
    
}
