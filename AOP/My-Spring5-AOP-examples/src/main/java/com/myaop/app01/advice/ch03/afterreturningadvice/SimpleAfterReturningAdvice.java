/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myaop.app01.advice.ch03.afterreturningadvice;

import java.lang.reflect.Method;
import java.util.Arrays;
import org.springframework.aop.AfterReturningAdvice;

/**
 *
 * @author Denys.Prokopiuk
 */
public class SimpleAfterReturningAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] os, Object target) throws Throwable {
        System.out.println("--------------------------------");
        System.out.println("@Before " + method.getName());
        System.out.println("Object[]= " + Arrays.toString(os));
        if ("speak".equalsIgnoreCase(method.getName())) {
            os[0] = "AOP effect";
        }
        System.out.println("Object (returnValue) = " + returnValue);
        System.out.println("Object (target) = " + target);
        System.out.println("--------------------------------");
        returnValue = "AOP";
    }

}
