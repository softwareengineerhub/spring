/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app02.validator.ch05.valid;

import com.app02.validator.ch04.customvalidator.AppConfig5;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main {
 
    public static void main(String[] args) {
          ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig6.class);
          PhoneService phoneService = ctx.getBean(PhoneService.class);
          Phone phone = new Phone();
          phoneService.process(phone);
    }
    
}
