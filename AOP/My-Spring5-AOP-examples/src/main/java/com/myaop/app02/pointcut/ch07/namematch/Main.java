/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myaop.app02.pointcut.ch07.namematch;

import com.myaop.app02.pointcut.ch01.staticmatcher.MySimpleAdviceISinger;
import com.myaop.app02.pointcut.ch02.simplenamematching.GrammySinger;
import com.myaop.app02.pointcut.ch02.simplenamematching.Guitar;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main {

    public static void main(String[] args) {
        GrammySinger grammySinger = new GrammySinger();

        NameMatchMethodPointcut pc = new NameMatchMethodPointcut();
//pc.addMethodName("sing");
        pc.addMethodName("rest");

        Advisor advisor = new DefaultPointcutAdvisor(pc, new MySimpleAdviceISinger());

        ProxyFactory pf = new ProxyFactory();
        pf.addAdvisor(advisor);
        pf.setTarget(grammySinger);

        GrammySinger proxy = (GrammySinger) pf.getProxy();
        proxy.sing();
        proxy.sing(new Guitar());
        proxy.rest();
        proxy.talk();
    }

}
