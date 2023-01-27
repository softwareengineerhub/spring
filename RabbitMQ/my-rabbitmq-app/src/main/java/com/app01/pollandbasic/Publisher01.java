package com.app01.pollandbasic;

import com.rabbitmq.client.*;

import java.util.Date;

public class Publisher01 {
    public static final String QUEUE_NAME = "users";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection("app:api:rest");

        try(Channel channel = connection.createChannel()){
            String exchange ="";
            String routingKey = QUEUE_NAME;
            AMQP.BasicProperties headers = null;

            int n = 30;
            for(int i=0;i<n;i++) {
                Thread.sleep(1000);
                String body = i+"; Test message "+ new Date();
                channel.basicPublish(exchange, routingKey, headers, body.getBytes());
                System.out.println("message was published");
            }
        }

        connection.close();

    }
}
