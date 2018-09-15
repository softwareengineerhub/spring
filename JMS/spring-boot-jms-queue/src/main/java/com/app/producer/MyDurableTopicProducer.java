package com.app.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.jms.*;

@Service
public class MyDurableTopicProducer {

    @Autowired
    @Qualifier("myDefaultConnectionFactory")
    private ConnectionFactory cf;
    @Autowired
    @Qualifier("myDurableTopicSpringBeanName")
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
