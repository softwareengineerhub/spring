/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.jms.example;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Denys.Prokopiuk
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestAppConfig.class})
public class ProducerTest {

    @Autowired
    private JmsTemplate template;

    @Test
    public void test() {
        template.send(new MessageCreator() {
            @Override
            public Message createMessage(Session sn) throws JMSException {
                return sn.createTextMessage("QQQQQQQ");
            }
        });
    }

}
