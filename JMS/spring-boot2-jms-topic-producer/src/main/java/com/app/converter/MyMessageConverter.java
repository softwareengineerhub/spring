package com.app.converter;

import com.app.model.MessageData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

@Component
public class MyMessageConverter implements MessageConverter {
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public Message toMessage(Object o, Session session) throws JMSException, MessageConversionException {
        try {
            String content = objectMapper.writeValueAsString(o);
            return session.createTextMessage(content);
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Object fromMessage(Message message) throws JMSException, MessageConversionException {
        try {
            TextMessage msg = (TextMessage) message;
            String content = msg.getText();
            return objectMapper.readValue(content, MessageData.class);
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
