package com.app.demp.utils;

import com.rabbitmq.client.*;

import java.time.LocalTime;

public class ProducerUtils {

    public static void publish(int count, String exchangeName, String routingKey) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection("end:to:end:test");) {
            Channel channel = connection.createChannel();
            //channel.exchangeDeclare(exchangeName, BuiltinExchangeType.TOPIC);
            AMQP.BasicProperties headers = null;

            for (int i = 0; i < count; i++) {
                String body = i + "; Test message; time=" + LocalTime.now();
                channel.basicPublish(exchangeName, routingKey, headers, body.getBytes());
                System.out.println(i + " message was published to ROUTING_KEY=" + routingKey);
            }
        }
    }


}
