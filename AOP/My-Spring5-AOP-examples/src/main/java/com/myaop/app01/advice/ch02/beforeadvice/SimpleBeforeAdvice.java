/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myaop.app01.advice.ch02.beforeadvice;

import java.lang.reflect.Method;
import java.util.Arrays;
import org.springframework.aop.MethodBeforeAdvice;

/**
 *
 * @author Denys.Prokopiuk
 */
public class SimpleBeforeAdvice implements MethodBeforeAdvice {
    
    @Override
    public void before(Method method, Object[] os, Object target) throws Throwable {
        System.out.println("@Before " + method.getName() + ", tune guitar.");
        System.out.println("Object[]= " + Arrays.toString(os));
        if("speak".equalsIgnoreCase(method.getName())){
            os[0] = "AOP effect";
        }
        System.out.println("Object (target) = " + target);
    }
    
}
