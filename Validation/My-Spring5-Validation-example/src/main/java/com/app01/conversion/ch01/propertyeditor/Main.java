/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app01.conversion.ch01.propertyeditor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/app01/conversion/ch01/propertyeditor/appConfig.xml");
        Singer eric = ctx.getBean("eric", Singer.class);
        System.out.println("Eric info: " + eric);
        Singer countrySinger = ctx.getBean("countrySinger", Singer.class);
        System.out.println("John info: " + countrySinger);
    }

}
