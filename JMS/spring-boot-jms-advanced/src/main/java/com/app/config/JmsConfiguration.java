package com.app.config;

import com.app.listener.MyJmsListener;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.connection.JmsTransactionManager;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jmx.export.MBeanExporter;
import org.springframework.jmx.export.assembler.MethodNameBasedMBeanInfoAssembler;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJms
@EnableMBeanExport
public class JmsConfiguration {


    @Value("${activemq.uri}")
    private String BROKER_URL;
    @Value("${activemq.username}")
    private String BROKER_USERNAME;
    @Value("${activemq.password}")
    private String BROKER_PASSWORD;
    @Value("${spring.jms.listener.acknowledge-mode}")
    private String ACKNOWLEDGE_MODE;
    @Value("${spring.jms.listener.auto-startup}")
    private boolean AUTO_STARTUP;
    @Value("${spring.jms.listener.concurrency}")
    private int LISTENER_CONCURRENCY;
    @Value("${spring.jms.listener.max-concurrency}")
    private int LISTENER_MAX_CONCURRENCY;
    @Value("${activemq.queue}")
    private String ACTIVEMQ_QUEUE;
    @Value("${spring.jms.listener.idle-cosumer-limit}")
    private int IDLE_CONSUMER_LIMIT;
    @Value("${spring.jms.listener.idle-task-execution-limit}")
    private int IDLE_TASK_EXECUTION_LIMIT;

    @Bean
    public MyJmsListener getListener() {
        return new MyJmsListener();
    }

    @Bean
    public DefaultMessageListenerContainer jmsMessageListenerContainer() {
        DefaultMessageListenerContainer factory = new DefaultMessageListenerContainer();
        factory.setTransactionManager(new JmsTransactionManager(connectionFactory()));
        //factory.setConcurrency(LISTENER_CONCURRENCY + "-" + LISTENER_MAX_CONCURRENCY);
        factory.setConcurrentConsumers(LISTENER_CONCURRENCY);
        factory.setMaxConcurrentConsumers(LISTENER_MAX_CONCURRENCY);
        factory.setConnectionFactory(connectionFactory());
        factory.setDestinationName(ACTIVEMQ_QUEUE);
        factory.setMessageListener(getListener());
        factory.setAutoStartup(AUTO_STARTUP);

        //amount of allowed idle (not working) consumers
        factory.setIdleConsumerLimit(IDLE_CONSUMER_LIMIT);

        //time for idle (not working) consumers
        factory.setIdleTaskExecutionLimit(IDLE_TASK_EXECUTION_LIMIT);

        factory.setMessageSelector("(age < 60) AND (age > 30)");

        return factory;
    }

    @Bean
    public ActiveMQConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(BROKER_URL);
        connectionFactory.setUserName(BROKER_USERNAME);
        connectionFactory.setPassword(BROKER_PASSWORD);
        return connectionFactory;
    }

    @Bean
    public MBeanExporter jmxConfig() {
        MBeanExporter exporter = new MBeanExporter();
        Map<String, Object> map = new HashMap();
        map.put("audit.service:type=JMSContainer,name=queueContainer", jmsMessageListenerContainer());
        exporter.setBeans(map);
        MethodNameBasedMBeanInfoAssembler assembler = new MethodNameBasedMBeanInfoAssembler();
        assembler.setManagedMethods("setMaxConcurrentConsumers", "getMaxConcurrentConsumers", "setConcurrentConsumers", "getConcurrentConsumers", "start", "stop", "isRunning", "setIdleConsumerLimit", "getIdleConsumerLimit", "setIdleTaskExecutionLimit", "getIdleTaskExecutionLimit");
        exporter.setAssembler(assembler);
        return exporter;
    }
}
