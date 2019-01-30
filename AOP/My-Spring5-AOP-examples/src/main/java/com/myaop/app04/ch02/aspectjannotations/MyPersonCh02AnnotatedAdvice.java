/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myaop.app04.ch02.aspectjannotations;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 *
 * @author Denys.Prokopiuk
 */
//@Component
//@Aspect
public class MyPersonCh02AnnotatedAdvice {

    //@Pointcut("execution(*com.myaop.app04.ch02.aspectjannotations..sing*(com.myaop.app02.pointcut.ch02.simplenamematching.Guitar) && args(value)")
    @Pointcut("execution(com.myaop.app04.ch02.aspectjannotationssing*())")
    public void singExecution(MyGuitar value) {
    }

    @Pointcut("bean(john*)")
    public void isJohn() {
    }

    @Before("singExecution(value) && isJohn()")
    public void simpleBeforeAdvice(JoinPoint joinPoint, MyGuitar value) {
        System.out.println("####Aspect: simpleBeforeAdvice");
        System.out.println("joinPoint.getSignature().getDeclaringTypeName()=" + joinPoint.getSignature().getDeclaringTypeName());
        System.out.println("joinPoint.getSignature().getName()=" + joinPoint.getSignature().getName());
    }

    @Around("singExecution(value) && isJohn()")
    public Object simpleAroundAdvice(ProceedingJoinPoint joinPoint, MyGuitar value) throws Throwable {
        System.out.println("@@@Before");
        Object res = joinPoint.proceed();
        System.out.println("@@@After");
        return res;
    }

}
