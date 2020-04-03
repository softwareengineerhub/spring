/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.config;

import com.app.components.MyBean;
import com.mycompany.spring.custom.scope.TenantBeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author asusadmin
 */
@Configuration(value = "com.app")
public class TenantScopeConfig {
    
    @Bean
    public static BeanFactoryPostProcessor beanFactoryPostProcessor() {
        return new TenantBeanFactoryPostProcessor();
    }
    
    @Scope("tenant")
    @Bean
    public MyBean myBean(){
        return new MyBean();
    }
    
}
