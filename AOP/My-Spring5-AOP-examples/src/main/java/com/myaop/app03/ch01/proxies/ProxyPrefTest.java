/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myaop.app03.ch01.proxies;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 *
 * @author Denys.Prokopiuk
 */
public class ProxyPrefTest {

    public static void main(String[] args) {
        SimpleBean target = new DefaultSimpleBean();

        Pointcut pc = new TestPointcut();
        Advice advice = new NoOpBeforeAdvice();
        Advisor advisor = new DefaultPointcutAdvisor(pc, advice);

        runCglibTests(advisor, target);
        runCglibFrozenTests(advisor, target);
        runJdkTests(advisor, target);
    }

    private static void runCglibTests(Advisor advisor, SimpleBean target) {
        System.out.println("-------------------------------------------");
        ProxyFactory pf = new ProxyFactory();
        pf.setProxyTargetClass(true);
        pf.setTarget(target);
        pf.addAdvisor(advisor);

        SimpleBean proxy = (SimpleBean) pf.getProxy();
        System.out.println("Running CGLIB (Standard) Tests");
        test(proxy);
        System.out.println("-------------------------------------------");
    }

    private static void runCglibFrozenTests(Advisor advisor, SimpleBean target) {
        System.out.println("-------------------------------------------");
        ProxyFactory pf = new ProxyFactory();
        pf.setProxyTargetClass(true);
        pf.setTarget(target);
        pf.addAdvisor(advisor);
        pf.setFrozen(true);
        SimpleBean proxy = (SimpleBean) pf.getProxy();
        System.out.println("Running CGLIB (Frozen) Tests");
        test(proxy);
        System.out.println("-------------------------------------------");
    }

    private static void runJdkTests(Advisor advisor, SimpleBean target) {
        System.out.println("-------------------------------------------");
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvisor(advisor);
        pf.setInterfaces(SimpleBean.class);
        SimpleBean proxy = (SimpleBean) pf.getProxy();
        System.out.println("Running JDK Tests");
        test(proxy);
        System.out.println("-------------------------------------------");
    }

    private static void test(SimpleBean bean) {
        long before = 0;
        long after = 0;

        System.out.println("Testing Advised Method");
        before = System.currentTimeMillis();
        for (int x = 0; x < 500000; x++) {
            bean.advised();
        }
        System.out.println("Took " + (System.currentTimeMillis() - before) + " ms");

        System.out.println("Testing Unadvised Method");
        before = System.currentTimeMillis();
        for (int x = 0; x < 500000; x++) {
            bean.unadvised();
        }
        System.out.println("Took " + (System.currentTimeMillis() - before) + " ms");

        System.out.println("Testing equals() Method");
        before = System.currentTimeMillis();
        for (int x = 0; x < 500000; x++) {
            bean.equals(bean);
        }
        System.out.println("Took " + (System.currentTimeMillis() - before) + " ms");

        System.out.println("Testing hashCode() Method");
        before = System.currentTimeMillis();
        for (int x = 0; x < 500000; x++) {
            bean.hashCode();
        }
        System.out.println("Took " + (System.currentTimeMillis() - before) + " ms");

        Advised advised = (Advised) bean;
        System.out.println("Testing Advised.getProxyTargetClass() Method");
        before = System.currentTimeMillis();
        for (int x = 0; x < 500000; x++) {
            advised.getTargetClass();
        }
        System.out.println("Took " + (System.currentTimeMillis() - before) + " ms");
        System.out.println(">>>\n");
    }

}
