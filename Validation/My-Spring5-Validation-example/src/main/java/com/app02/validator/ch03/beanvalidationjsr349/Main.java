/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app02.validator.ch03.beanvalidationjsr349;

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
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig4.class);
        MyValidationService myValidationService = ctx.getBean(MyValidationService.class);
        Dog dog = new Dog();
        dog.setName("Name1");
        TypeOfDog typeOfDog = new TypeOfDog();
      //  typeOfDog.setColor("Brown");
        dog.setTypeOfDog(typeOfDog);
        Set<ConstraintViolation<Dog>> set = myValidationService.validate(dog);
        System.out.println(set.size());
    }
    
}
