/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myaop.app04.ch02.aspectjannotations;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 *
 * @author Denys.Prokopiuk
 */
@Component
@Aspect
public class MyAspectDenis {
    
    @Pointcut("execution(* doAction(..))")
    public void myMethod(){
        
    }
    
    
    //@Before("execution(public void com.myaop.app04.ch02.aspectjannotations.MyPersonCh02.doAction())")
    @Before("myMethod()")
    public void simpleBeforeAdvice(JoinPoint joinPoint, MyGuitar value) {
        System.out.println("####Aspect: simpleBeforeAdvice");
        System.out.println("joinPoint.getSignature().getDeclaringTypeName()=" + joinPoint.getSignature().getDeclaringTypeName());
        System.out.println("joinPoint.getSignature().getName()=" + joinPoint.getSignature().getName());
    }
    
}
