package com.app.producer;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.jms.*;

@Component
public class MyJmsProducer {
    @Autowired
    private ConnectionFactory connectionFactory;
    @Value("${activemq.queue}")
    private String queueName;

    @Scheduled(fixedRate = 30000)
    public void init(){
        try {
            System.out.println("Produce message");
            Connection c = connectionFactory.createConnection();
            Session session = c.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(new ActiveMQQueue(queueName));
            Message message = session.createTextMessage("Text Message!!!");
            //message.setIntProperty("age", 40);

            message.setIntProperty("age", 400);

            messageProducer.send(message);
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
