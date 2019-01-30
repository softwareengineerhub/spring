/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myaop.app01.advice.ch02.beforeadvice;

import org.springframework.aop.framework.ProxyFactory;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main {
    
    public static void main(String[] args) {
        Guitarist johnMayer = new Guitarist();
        
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new SimpleBeforeAdvice());
        pf.setTarget(johnMayer);
        
        Guitarist proxy = (Guitarist) pf.getProxy();
        proxy.sing();     
        proxy.speak("Hello");
    }
    
}
