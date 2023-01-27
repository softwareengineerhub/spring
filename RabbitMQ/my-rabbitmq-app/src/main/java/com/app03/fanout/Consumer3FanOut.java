package com.app03.fanout;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.Map;

public class Consumer3FanOut {
    static String queueName = "myFanOut3";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        Connection connection = factory.newConnection("app:api:rest");
        Channel channel = connection.createChannel();


        boolean durable = false;
        boolean exclusive = false;
        boolean autoDelete = false;
        Map<String, Object> arguments = null;
        channel.queueDeclare(queueName, durable, exclusive, autoDelete, arguments);
        channel.exchangeDeclare("quotes_exchange", BuiltinExchangeType.FANOUT);
        String routingKey = "";
        channel.queueBind(queueName, "quotes_exchange", routingKey);


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