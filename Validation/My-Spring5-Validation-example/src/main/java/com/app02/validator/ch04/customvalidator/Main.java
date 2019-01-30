/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app02.validator.ch04.customvalidator;

import com.app02.validator.ch02.beanvalidationjsr349.Employee;
import com.app02.validator.ch02.beanvalidationjsr349.SingerValidationService;
import java.util.Set;
import javax.validation.ConstraintViolation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main {
    
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig5.class);
        MySingerValidationService validatorService = ctx.getBean(MySingerValidationService.class);
        MySinger mySinger = new MySinger();
        mySinger.setLastName("ttt");
        //mySinger.setFirstName("qqq");
        Set<ConstraintViolation<MySinger>> res = validatorService.validateMySinger(mySinger);
        System.out.println(res.size());
    }
    
}
