/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.core.bean.names.annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyEmployee myEmployee = (MyEmployee) ctx.getBean("myEmployee");
        myEmployee.doAction();
        MyEmployee2 myEmployee2 = (MyEmployee2) ctx.getBean("emp2");
        myEmployee2.doAction();
    }

}
