/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myaop.app02.pointcut.ch09.composition.pointcut;

import java.lang.reflect.Method;
import org.springframework.aop.support.StaticMethodMatcher;

/**
 *
 * @author Denys.Prokopiuk
 */
public class SingMethodMatcher extends StaticMethodMatcher {

    @Override
    public boolean matches(Method method, Class<?> type) {
        return (method.getName().startsWith("si"));
    }

}
