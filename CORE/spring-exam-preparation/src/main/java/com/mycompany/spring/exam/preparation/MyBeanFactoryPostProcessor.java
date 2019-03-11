/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring.exam.preparation;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 *
 * @author asusadmin
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory clbf) throws BeansException {
        System.out.println("MyBeanFactoryPostProcessor");
        clbf.registerSingleton("defaultPerson", new Person());
      //  Person p = clbf.getBean(Person.class, "a");
      //  p.setName(p.getName()+"; enriched");
    }
    
}
