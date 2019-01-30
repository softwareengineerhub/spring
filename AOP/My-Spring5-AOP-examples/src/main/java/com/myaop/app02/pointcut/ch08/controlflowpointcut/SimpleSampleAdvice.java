/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myaop.app02.pointcut.ch08.controlflowpointcut;

import java.lang.reflect.Method;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.MethodBeforeAdvice;

/**
 *
 * @author Denys.Prokopiuk
 */
public class SimpleSampleAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] os, Object o) throws Throwable {
        System.out.println("Before method: " + method);
    }
    
    
    
}
