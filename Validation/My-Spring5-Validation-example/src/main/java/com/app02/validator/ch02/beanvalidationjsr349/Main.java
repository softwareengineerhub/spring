/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app02.validator.ch02.beanvalidationjsr349;

import com.app01.conversion.ch02.convertor.AppConfig;
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
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig3.class);
        SingerValidationService validator = ctx.getBean(SingerValidationService.class);
        
        Employee emp = new Employee();
        emp.setFirstName("FirstName");
        emp.setLastName("LastName");
        
        Gender gender = new Gender();
        gender.setValue("MALE");
        emp.setGender(gender);
        
        Set<ConstraintViolation<Employee>> res = validator.validateSinger(emp);
        for(ConstraintViolation item: res){
            System.out.println("-----------------");
            System.out.println(item);
        }
    }
    
}
