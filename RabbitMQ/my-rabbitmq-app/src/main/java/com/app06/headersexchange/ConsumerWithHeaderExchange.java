package com.app06.headersexchange;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ConsumerWithHeaderExchange {
    static String ROUTING_KEY = "";
    static String QUEUE_NAME = "my-queue_headers";
    static String EXCHANGE_NAME = "quotes_exchange_headers";


    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        Connection connection = factory.newConnection("app:api:rest");
        Channel channel = connection.createChannel();


        Map<String, Object> headersMap = new HashMap<>();
        headersMap.put("x-match", "any");
        //headersMap.put("x-match", "all");
        headersMap.put("insurance", "car");
        headersMap.put("vehicle", "motobike");


        boolean durable = true;
        boolean exclusive = true;
        boolean autoDelete = true;
        Map<String, Object> arguments = null;

        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.HEADERS);
        channel.queueDeclare(QUEUE_NAME, durable, exclusive, autoDelete, arguments);
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, ROUTING_KEY, headersMap);


        boolean autoAck = true;
        channel.basicConsume(QUEUE_NAME, autoAck, new DeliverCallback() {
            @Override
            public void handle(String consumerTag, Delivery delivery) throws IOException {
                System.out.println("consumerTag=" + consumerTag);
                byte[] data = delivery.getBody();
                String body = new String(data);
                System.out.println("body=" + body);
                AMQP.BasicProperties props = delivery.getProperties();
                System.out.println("props=" + props);
                Map<String, Object> msgHeaders = props.getHeaders();
                System.out.println("msgHeaders="+msgHeaders);
                System.out.println("----------------------------");
            }
        }, (CancelCallback) null);

    }

}
