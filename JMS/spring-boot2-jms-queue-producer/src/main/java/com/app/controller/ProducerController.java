package com.app.controller;

import com.app.model.MessageData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.*;

@RestController
public class ProducerController {
    @Autowired
    private ConnectionFactory connectionFactory;
    @Autowired
    private Destination destination;
    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/send")
    public void sendData(@RequestBody MessageData messageData) {
        try {
            Connection con = connectionFactory.createConnection();
            Session session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
            String content = objectMapper.writeValueAsString(messageData);
            Message msg = session.createTextMessage(content);
            MessageProducer messageProducer = session.createProducer(destination);
            messageProducer.send(msg);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
