/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myaop.app02.pointcut.ch01.staticmatcher;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main {
    
    public static void main(String[] args) {
        
        Pointcut pc = new SimpleStaticPointcut();
        Advice advice = new MySimpleAdviceISinger();
        Advisor advisor = new DefaultPointcutAdvisor(pc, advice);
        
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvisor(advisor);
        pf.setTarget(new Singer1());
        
        Singer1 proxy1 = (Singer1) pf.getProxy();
        proxy1.sing();
        
        pf.setTarget(new Singer2());
        Singer2 proxy2 = (Singer2) pf.getProxy();
        proxy2.sing();
        
    }
}
