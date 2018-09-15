package com.app.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

@Component
public class MyJMSProducer {

    @Autowired
    @Qualifier("myDefaultJMSTemplate")
    private JmsTemplate template;

    public void sendMessage(String text){
        template.send("appQueue1", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage msg=session.createTextMessage();
                msg.setText(text);
                return msg;
            }
        });
    }

}
