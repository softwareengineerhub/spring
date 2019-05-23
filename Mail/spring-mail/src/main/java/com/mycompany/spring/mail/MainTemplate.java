/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring.mail;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MainTemplate {
    
    
    public static void main(String[] args) {
          ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
          TemplateServiceImpl templateServiceImpl = ctx.getBean(TemplateServiceImpl.class);
          templateServiceImpl.process();
    }
}
