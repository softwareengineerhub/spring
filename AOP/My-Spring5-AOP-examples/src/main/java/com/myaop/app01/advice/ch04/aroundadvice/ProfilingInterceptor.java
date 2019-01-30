/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myaop.app01.advice.ch04.aroundadvice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 *
 * @author Denys.Prokopiuk
 */
public class ProfilingInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        Object res = null;
        System.out.println("@Before call");
        if(mi.getMethod().getName().equals("doSomeWork")){
            res = mi.getMethod().invoke(mi.getThis(), 10);
        } else {
            res = mi.proceed();
        }
        System.out.println("@After call");
        return res;
    }

}
