/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myaop.app03.ch01.proxies;

import java.lang.reflect.Method;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

/**
 *
 * @author Denys.Prokopiuk
 */
public class TestPointcut extends StaticMethodMatcherPointcut {

    @Override
    public boolean matches(Method method, Class<?> type) {
        return "advise".equals(method.getName());
    }

}
