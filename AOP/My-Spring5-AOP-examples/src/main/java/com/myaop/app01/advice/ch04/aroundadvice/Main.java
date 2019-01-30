/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myaop.app01.advice.ch04.aroundadvice;

import org.springframework.aop.framework.ProxyFactory;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main {
    
    public static void main(String[] args) {
        WorkBean workBean = new WorkBean();
        
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new ProfilingInterceptor());
        pf.setTarget(workBean);
        
        WorkBean proxy = (WorkBean) pf.getProxy();
        proxy.doSomeWork(5);
    }
    
}
