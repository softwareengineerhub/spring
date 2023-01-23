package com.app.demp.config;

import com.app.demp.consumer.MyListener;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.export.MBeanExporter;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class MyRabbitMQConfig {

    private static final String MY_QUEUE = "MyQueue";

    @Bean
    public MBeanExporter getJmxExporter() {
        MBeanExporter mbe = new MBeanExporter();
        Map<String, Object> map = new HashMap();
        map.put("bean:name=MySimpleListenerContainer", messageListenerContainer());
        mbe.setBeans(map);
        return mbe;
    }


    @Bean
    public Queue myQueue(){
        boolean durability = true;
        return new Queue(MY_QUEUE, durability);
    }

    @Bean
    public Exchange myExchange(){
        return ExchangeBuilder.topicExchange("MyTopicExchange").durable(true).build();
    }

    @Bean
    Binding binding() {
        String routingKey = "topic";
        return BindingBuilder.bind(myQueue()).to(myExchange()).with(routingKey).noargs();
    }

    @Bean
    public ConnectionFactory connectionFactory(){
        String hostName = "localhost";
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(hostName);
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        return connectionFactory;
    }

    @Bean
    public SimpleMessageListenerContainer messageListenerContainer(){
        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
        simpleMessageListenerContainer.setConnectionFactory(connectionFactory());
        simpleMessageListenerContainer.setQueues(myQueue());
        simpleMessageListenerContainer.setConcurrentConsumers(2);
        simpleMessageListenerContainer.setMessageListener(new MyListener());
        return simpleMessageListenerContainer;
    }
}
