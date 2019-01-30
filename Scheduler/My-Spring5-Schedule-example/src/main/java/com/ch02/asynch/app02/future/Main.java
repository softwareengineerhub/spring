/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ch02.asynch.app02.future;

import java.util.concurrent.Future;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main {
    
    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig5.class);
        CarService5 cs = ctx.getBean(CarService5.class);
        Future<String> res=cs.doAction();
        String value=res.get();
        System.out.println(value);
        cs.doProcess();
    }
    
}
