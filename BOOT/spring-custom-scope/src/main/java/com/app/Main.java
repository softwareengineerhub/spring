/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app;

import com.app.components.MyBean;
import com.app.config.TenantScopeConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author asusadmin
 */
public class Main {
    
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(TenantScopeConfig.class);
        MyBean myBean = ctx.getBean(MyBean.class);
        String info = myBean.getInfo();
        System.out.println(info);
        myBean = ctx.getBean(MyBean.class);
        String info2 = myBean.getInfo();
        System.out.println(info2);
        
    }
    
}
