/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.advancedcore.app.initbeanjavaconf;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main3 {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        MyCar myCar = (MyCar) ctx.getBean("myCar");
        System.out.println("-----------------------");
        System.out.println(myCar);
    }

}
