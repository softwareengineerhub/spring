package com.app.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;

@SpringBootConfiguration
@EnableJms
public class QueueSpringConfig {

    @Bean(name = "queueSpringBeanName")
    public Destination getQueueDestination(){
        return new ActiveMQQueue("appQueue1");
    }

    @Bean(name = "myQueueFactory")
    public JmsListenerContainerFactory<?> queueFactory(ConnectionFactory connectionFactory, DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();// lambda function
        factory.setErrorHandler(t -> System.err.println("An error has occurred in the transaction"));
        configurer.configure(factory, connectionFactory);
        return factory;
    }


}
