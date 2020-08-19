package com.app.controller;

import com.app.model.MessageData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.*;

@RestController
public class ProducerControllerWithJmsTemplate {

    @Autowired
    private JmsTemplate jmsTemplate;

    @PostMapping("/send-with-template")
    public void sendData(@RequestBody MessageData messageData) {
        System.out.println("messageData=" + messageData);
        jmsTemplate.convertAndSend(messageData);
    }

}
