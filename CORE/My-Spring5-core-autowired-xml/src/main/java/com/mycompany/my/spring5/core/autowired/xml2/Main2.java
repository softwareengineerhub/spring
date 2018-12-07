/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.core.autowired.xml2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main2 {
    
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("app-context2.xml");
        MyRepository myRepository = (MyRepository) ctx.getBean("myRepository");
        myRepository.doAction();
        MyRepository myRepository2 = (MyRepository) ctx.getBean("myRepository2");
        myRepository2.doAction();
    }
    
}
