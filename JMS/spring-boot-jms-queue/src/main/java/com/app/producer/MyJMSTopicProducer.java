package com.app.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.jms.*;

@Component
public class MyJMSTopicProducer {

    @Autowired
    @Qualifier("myDefaultConnectionFactory")
    private ConnectionFactory cf;
    @Autowired
    @Qualifier("topicSpringBeanName")
    private Destination destination;

    public void sendMessage(String message){
        try {
            Connection connection = cf.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Message msg = session.createTextMessage(message);
            MessageProducer producer = session.createProducer(destination);
            producer.send(msg);
        }catch(Exception ex){
            throw  new RuntimeException(ex);
        }
    }


}
