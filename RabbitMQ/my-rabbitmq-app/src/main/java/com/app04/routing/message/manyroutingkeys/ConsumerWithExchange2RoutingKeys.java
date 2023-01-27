package com.app04.routing.message.manyroutingkeys;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.Map;

public class ConsumerWithExchange2RoutingKeys {

    static String ROUTING_KEY = "direct-route";
    static String ROUTING_KEY2 = "direct-route2";
    static String QUEUE_NAME = "direct-queue";
    static String EXCHANGE_NAME = "direct-exchange";


    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        Connection connection = factory.newConnection("app:api:rest");
        Channel channel = connection.createChannel();

        boolean durable = true;
        boolean exclusive = true;
        boolean autoDelete = true;
        Map<String, Object> arguments = null;

        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);
        channel.queueDeclare(QUEUE_NAME, durable, exclusive, autoDelete, arguments);

        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, ROUTING_KEY);
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, ROUTING_KEY2);


        boolean autoAck = true;
        channel.basicConsume(QUEUE_NAME, autoAck, new DeliverCallback() {
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
