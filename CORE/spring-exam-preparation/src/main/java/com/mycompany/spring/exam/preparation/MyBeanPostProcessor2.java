/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring.exam.preparation;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 *
 * @author asusadmin
 */
public class MyBeanPostProcessor2 implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        try {
            System.out.println("\t\tCalled postProcessBeforeInitialization() for :" + beanName+"; value="+bean);
            Thread.sleep(5000);
            return bean;
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("\t\tCalled postProcessAfterInitialization() for :" + beanName+"; value="+bean);
        return bean;
    }
}
