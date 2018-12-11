/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.advancedcore.app.applicationcontextaware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author asusadmin
 */
//@Component(value = "shutdownHook")
@Component
public class MyShutdownHook  implements ApplicationContextAware {

    private ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext ac) throws BeansException {
        this.ctx=ac;
        AnnotationConfigApplicationContext context = (AnnotationConfigApplicationContext) ac;
        context.registerShutdownHook();
        System.out.println("####setApplicationContext");
    }

}
