/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.config;

import com.app.consumer.MyConsumer2;
import javax.jms.ConnectionFactory;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

/**
 *
 * @author Denys.Prokopiuk
 */
@SpringBootApplication
@EnableJms
@ComponentScan(basePackages = {"com"})
public class MySpringConfig {
    
    @Bean
    public JmsTemplate getJMSTemplate(){
        JmsTemplate template = new JmsTemplate(getConnectionFactory());
        template.setDefaultDestinationName("myQueue");
        return template;
    }
    
    @Bean(name = "myFactory")
    public ConnectionFactory getConnectionFactory(){
        return new ActiveMQConnectionFactory();
    }
    
    @Bean
    public MyConsumer2  m(){
        return new MyConsumer2();
    }
    
}
