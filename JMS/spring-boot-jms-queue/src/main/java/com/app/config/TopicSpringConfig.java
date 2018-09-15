package com.app.config;

import org.apache.activemq.command.ActiveMQTopic;
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
public class TopicSpringConfig {

    @Bean(name = "myTopicFactory")
    public JmsListenerContainerFactory<?> myTopicFactory(ConnectionFactory connectionFactory, DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setPubSubDomain(true);
        return factory;
    }

    @Bean(name = "topicSpringBeanName")
    public Destination getTopicDestination(){
        return new ActiveMQTopic("appTopic1");
    }




}
