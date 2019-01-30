/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myaop.app02.pointcut.ch02.dynamicmatcher;

import java.lang.reflect.Method;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

/**
 *
 * @author Denys.Prokopiuk
 */
public class SimpleDynamicPointcut extends DynamicMethodMatcherPointcut {

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        System.out.println("Static matches");
        return super.matches(method, targetClass);
    }

    @Override
    public boolean matches(Method method, Class<?> type, Object... os) {
        System.out.println("Dynamic check for " + method.getName());
        return true;
    }

}
