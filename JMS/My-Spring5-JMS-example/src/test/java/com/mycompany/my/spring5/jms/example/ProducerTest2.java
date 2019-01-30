/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.jms.example;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;

/**
 *
 * @author Denys.Prokopiuk
 */
public class ProducerTest2 {

    @Test
    public void test() throws Exception {
        ConnectionFactory cf = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection c = cf.createConnection();
        Session session = c.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Message msg = session.createTextMessage("qqq");
        Destination queue = new ActiveMQQueue("myQueue");
        MessageProducer producer = session.createProducer(queue);
        producer.send(msg);
    }

}
