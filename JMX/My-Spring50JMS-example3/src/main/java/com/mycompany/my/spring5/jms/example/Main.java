/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.jms.example;

import org.apache.activemq.broker.BrokerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main {
    
    public static void main(String[] args) throws Exception {
        BrokerService broker = new BrokerService();
        //  broker.addConnector("tcp://localhost:61616");
        // broker.start();

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        /* ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        MyProducer myProducer = ctx.getBean(MyProducer.class);
        
        System.out.println("-----------------------Context started---------------------------");
        Thread.sleep(3000);
        
        for (int i = 0; i < 10; i++) {
            myProducer.send("Message #" + i);
        }*/
    }
    
}
