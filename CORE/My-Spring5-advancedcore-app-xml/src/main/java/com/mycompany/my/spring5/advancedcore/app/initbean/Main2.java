/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.advancedcore.app.initbean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main2 {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("app-ctx2.xml");
        MyCat cat = (MyCat) ctx.getBean("cat");
        System.out.println(cat);
    }

}
