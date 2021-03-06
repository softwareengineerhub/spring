/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.app.myconfig;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        Employee emp = ctx.getBean(Employee.class);
        System.out.println(emp);

        MyService myService = (MyService) ctx.getBean("myService");

        myService.persist(new MyPerson("p0", 0));
        myService.persist(new MyPerson("p1", 1));
        MyPerson oldValue = myService.update(new MyPerson("updatep1", -1), 1, "p1");
        System.out.println("oldValue=" + oldValue);
        List<MyPerson> list = myService.findAll();
        System.out.println("------------list----------------");
        for (MyPerson person : list) {
            System.out.println(person);
        }
        
        ctx.destroy();

    }

}
