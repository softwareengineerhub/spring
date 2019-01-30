/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.jms.example;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

/**
 *
 * @author Denys.Prokopiuk
 */
//@Component
public class MyProducer {

    @Autowired
    private JmsTemplate template;

    public void send(String message) {
        template.send(new MessageCreator() {

            @Override
            public Message createMessage(Session sn) throws JMSException {
                return sn.createTextMessage(message);
            }
        });
    }
}
