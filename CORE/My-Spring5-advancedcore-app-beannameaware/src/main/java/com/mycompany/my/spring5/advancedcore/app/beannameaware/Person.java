/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.advancedcore.app.beannameaware;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

/**
 *
 * @author asusadmin
 */
@Component
public class Person implements BeanNameAware {

    @PostConstruct
    public void init() {
        System.out.println("Person.@PostConstruct");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("@@@@@setBeanName;name=" + name);
    }

}
