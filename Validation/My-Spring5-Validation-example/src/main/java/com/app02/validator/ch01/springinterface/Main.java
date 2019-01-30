/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app02.validator.ch01.springinterface;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main {
    
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig2.class);
        
        Singer singer = new Singer();
        singer.setFirstName(null);
        singer.setLastName("Mayer");
        
        BeanPropertyBindingResult result = new BeanPropertyBindingResult(singer, "John");
        
        Validator singleValidator = ctx.getBean(Validator.class);
        
        ValidationUtils.invokeValidator(singleValidator, singer, result);
        
        List<ObjectError> errors = result.getAllErrors();
        for(ObjectError error: errors){
            System.out.println(error);
        }
        
    }
    
}
