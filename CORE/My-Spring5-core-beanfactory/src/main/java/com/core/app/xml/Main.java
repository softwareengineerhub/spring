/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.app.xml;

import java.util.List;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main {
    
    public static void main(String[] args) {
        
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(new ClassPathResource("applicationContext.xml"));
        
        
      //  ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyService myService = (MyService) factory.getBean("myService");
        
        myService.persist(new MyPerson("p0", 0));
        myService.persist(new MyPerson("p1", 1));
        MyPerson oldValue = myService.update(new MyPerson("updatep1", -1), 1, "p1");
        System.out.println("oldValue="+oldValue);
        List<MyPerson> list=myService.findAll();
        System.out.println("------------list----------------");
        for(MyPerson person : list){
            System.out.println(person);
        }
        
    }
    
}
