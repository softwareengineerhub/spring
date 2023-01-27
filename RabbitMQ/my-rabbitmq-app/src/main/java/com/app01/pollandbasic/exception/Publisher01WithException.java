package com.app01.pollandbasic.exception;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.util.Date;

public class Publisher01WithException {
    public static final String QUEUE_NAME = "users";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection("app:api:rest");

        try(Channel channel = connection.createChannel()){
            String exchange ="";
            String routingKey = QUEUE_NAME;
            AMQP.BasicProperties headers = null;

            int n = 1;
            for(int i=0;i<n;i++) {
                Thread.sleep(10);
                String body = i+"; ex Test message "+ new Date();
                channel.basicPublish(exchange, routingKey, headers, body.getBytes());
                System.out.println("message was published");
            }
        }

        connection.close();

    }
}
