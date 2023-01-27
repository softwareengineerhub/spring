package com.app05.topicexchange.samplec;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.Map;

public class ConsumerWithTopicExchangeC {

    static String ROUTING_KEY = "*.car.#";
    static String QUEUE_NAME = "my-queue";
    static String EXCHANGE_NAME = "quotes_exchange_topic";


    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        Connection connection = factory.newConnection("app:api:rest");
        Channel channel = connection.createChannel();

        boolean durable = true;
        boolean exclusive = true;
        boolean autoDelete = true;
        Map<String, Object> arguments = null;

        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC);
        channel.queueDeclare(QUEUE_NAME, durable, exclusive, autoDelete, arguments);
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, ROUTING_KEY);


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
