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
public class DurableTopicSpringConfig {

    @Bean(name = "topicDurable1Factory")
    public JmsListenerContainerFactory<?> topicDurable1Factory(ConnectionFactory connectionFactory, DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setSubscriptionDurable(true);
        factory.setClientId("topicDurable1");
        factory.setPubSubDomain(true);
        return factory;
    }

    @Bean(name = "topicDurable2Factory")
    public JmsListenerContainerFactory<?> topicDurable2Factory(ConnectionFactory connectionFactory, DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setSubscriptionDurable(true);
        factory.setClientId("topicDurable2");
        factory.setPubSubDomain(true);
        return factory;
    }

    @Bean(name = "topicDurable3Factory")
    public JmsListenerContainerFactory<?> topicDurable3Factory(ConnectionFactory connectionFactory, DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setSubscriptionDurable(true);
        factory.setClientId("topicDurable3");
        factory.setPubSubDomain(true);
        return factory;
    }

    //
    @Bean(name = "myDurableTopicSpringBeanName")
    public Destination getTopicDestination(){
        return new ActiveMQTopic("myDurableTopic");
    }


}
