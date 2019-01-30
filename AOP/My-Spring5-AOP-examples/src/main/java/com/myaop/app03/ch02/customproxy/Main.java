/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myaop.app03.ch02.customproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.concurrent.Callable;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main {

    public static void main(String[] args) {
        Class[] classes = new Class[]{Comparable.class, Callable.class};
        Object proxy = Proxy.newProxyInstance(null, classes, new InvocationHandler() {

            @Override
            public Object invoke(Object o, Method method, Object[] os) throws Throwable {
                //System.out.println("o=" + o);
                System.out.println("method=" + method);
                System.out.println("os=" + Arrays.toString(os));
                return "Test";
            }
        });

        String res = proxy.toString();
        System.out.println("res=" + res);
    }

}
