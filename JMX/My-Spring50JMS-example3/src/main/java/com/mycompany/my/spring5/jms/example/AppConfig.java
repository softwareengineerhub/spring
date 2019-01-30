/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.jms.example;

import java.util.HashMap;
import java.util.Map;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jmx.export.MBeanExporter;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.jmx.export.assembler.InterfaceBasedMBeanInfoAssembler;
import org.springframework.jmx.export.assembler.MethodNameBasedMBeanInfoAssembler;

/**
 *
 * @author Denys.Prokopiuk
 */
@Configuration
@EnableJms
@EnableMBeanExport
@ComponentScan("com.mycompany.my.spring5.jms.example")
public class AppConfig {

    @Bean
    public MyListener getListener() {
        return new MyListener();
    }

    @Bean
    public ActiveMQConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL("tcp://localhost:61616");
        return connectionFactory;
    }

    @Bean
    public DefaultMessageListenerContainer jmsMessageListenerContainer() {
        DefaultMessageListenerContainer dmlc = new DefaultMessageListenerContainer();
        int lower = 10;
        int upper = 10;
        dmlc.setConcurrency(lower + "-" + upper);
        dmlc.setConnectionFactory(connectionFactory());
        dmlc.setDestinationName("myQueue");
        dmlc.setConcurrentConsumers(upper);
        dmlc.setMessageListener(getListener());
        dmlc.setAutoStartup(true);
        return dmlc;
    }

    @Bean
    public JmsTemplate getJMSTemplate() {
        JmsTemplate template = new JmsTemplate(connectionFactory());
        template.setDefaultDestinationName("myQueue");
        return template;
    }

    
    @Bean
    public MBeanExporter jmx() {
        MBeanExporter exporter = new MBeanExporter();
        Map<String, Object> map = new HashMap();
        //   map.put("spring.application:type=JMSContainer,name=testQueueContainer", jmsListenerContainerFactory());
        map.put("spring.application:type=JMSContainer,name=testQueueContainer2", jmsMessageListenerContainer());
        exporter.setBeans(map);

        MethodNameBasedMBeanInfoAssembler assembler = new MethodNameBasedMBeanInfoAssembler();
        assembler.setManagedMethods("setMaxConcurrentConsumers", "getMaxConcurrentConsumers", "setConcurrentConsumers", "getConcurrentConsumers", "start", "stop", "isRunning");
        
        
        InterfaceBasedMBeanInfoAssembler ibmbia = new InterfaceBasedMBeanInfoAssembler();
        ibmbia.setManagedInterfaces(org.springframework.context.Lifecycle.class);
        
        exporter.setAssembler(ibmbia);
        exporter.setAssembler(assembler);
        return exporter;
    }

}
