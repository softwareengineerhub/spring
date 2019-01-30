/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app01.smaple.ch01.hello;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Denis
 */
public class Main {
    
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfiguration.class);
        AppStatistics appStatistics = ctx.getBean(AppStatistics.class);
        //int count = appStatistics.count();
        //System.out.println("count="+count);
       
       
        Thread.sleep(Integer.MAX_VALUE);
    }
}
