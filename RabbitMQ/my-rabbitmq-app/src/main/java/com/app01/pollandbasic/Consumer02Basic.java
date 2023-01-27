package com.app01.pollandbasic;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.Map;

public class Consumer02Basic {

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        Connection connection = factory.newConnection("app:api:rest");
        Channel channel = connection.createChannel();
        String queueName = "users";
        boolean durable = false;
        boolean exclusive = false;
        boolean autoDelete = false;
        Map<String, Object> arguments = null;
        channel.queueDeclare(queueName, durable, exclusive, autoDelete, arguments);

        boolean autoAck = true;
        channel.basicConsume(queueName, autoAck, new DeliverCallback() {
            @Override
            public void handle(String consumerTag, Delivery delivery) throws IOException {
                System.out.println("consumerTag=" + consumerTag);
                byte[] data = delivery.getBody();
                String body = new String(data);
                System.out.println("body=" + body);
                System.out.println("----------------------------");
            }
        }, (CancelCallback) null);

    }

}
