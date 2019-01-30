/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myaop.app01.advice.ch03.afterreturningadvice;

import org.springframework.aop.framework.ProxyFactory;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main {

    public static void main(String[] args) {
        MySinger mySinger = new MySinger();

        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new SimpleAfterReturningAdvice());
        pf.setTarget(mySinger);

        MySinger proxy = (MySinger) pf.getProxy();
        proxy.sing();
        String res = proxy.speak("Hello");
        System.out.println("res=" + res);
    }

}
