/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.jms.example;

import java.util.HashMap;
import java.util.Map;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

/**
 *
 * @author Denys.Prokopiuk
 */
@Configuration
@EnableJms
@EnableMBeanExport
@ComponentScan("com.mycompany.my.spring5.jms.example")
public class AppConfig {
    
    @Autowired
    private MyListener myListener;
    
    @Bean
    public ActiveMQConnectionFactory connectionFactory(){
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL("tcp://localhost:61616");        
        return connectionFactory;
    }
    
    /*@Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {        
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();        
        factory.setConnectionFactory(connectionFactory());
        int lower = 10;
        int upper = 10;
        factory.setConcurrency(lower+"-"+upper);
        return factory;
    }*/
    
    @Bean
    public DefaultMessageListenerContainer jmsListenerContainerFactory() {        
        DefaultMessageListenerContainer dmlc = new DefaultMessageListenerContainer();
        dmlc.setConnectionFactory(connectionFactory());
        dmlc.setDestinationName("myQueue");
        dmlc.setMessageListener(myListener);
        dmlc.setAutoStartup(true);
        return dmlc;
    }
    
    
    @Bean
    public JmsTemplate getJMSTemplate(){
        JmsTemplate template = new JmsTemplate(connectionFactory());
        template.setDefaultDestinationName("myQueue");
        return template;
    }
    
    /*
    @Bean(name = "myConnectionFactory")
    public ConnectionFactory connectionFactory() {
         return new ActiveMQConnectionFactory();
    }
    
    @Bean(name = "queueSpringBeanName")
    public Destination getQueueDestination(){
        return new ActiveMQQueue("myQueue");
    }

    @Bean(name = "myQueueFactory")
    public JmsListenerContainerFactory<?> queueFactory(ConnectionFactory connectionFactory, DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();// lambda function
        factory.setErrorHandler(t -> System.err.println("An error has occurred in the transaction"));
        configurer.configure(factory, connectionFactory);
        return factory;
    }*/

}
