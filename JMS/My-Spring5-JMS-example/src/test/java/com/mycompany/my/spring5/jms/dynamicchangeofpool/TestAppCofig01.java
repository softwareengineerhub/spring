/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.jms.dynamicchangeofpool;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

/**
 *
 * @author Denys.Prokopiuk
 */
@Configuration
@ComponentScan(basePackages = {"com.mycompany.my.spring5.jms.example"})
public class TestAppCofig01 {
    
    @Bean
    public ActiveMQConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL("tcp://localhost:61616");
        return connectionFactory;
    }

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        int lower = 7;
        int upper = 7;
        factory.setConcurrency(lower + "-" + upper);
        return factory;
    }

    @Bean
    public JmsTemplate getJMSTemplate() {
        JmsTemplate template = new JmsTemplate(connectionFactory());
        template.setDefaultDestinationName("myQueue");
        return template;
    }
}
