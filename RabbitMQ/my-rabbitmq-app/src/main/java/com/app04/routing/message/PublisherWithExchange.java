package com.app04.routing.message;

import com.rabbitmq.client.*;

import java.util.Date;

public class PublisherWithExchange {

    private static String EXCHANGE_NAME = "direct-exchange";
    private static String ROUTING_KEY = "direct-route";
    private static String ROUTING_KEY2 = "direct-route2";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection("app:api:rest");

        try(Channel channel = connection.createChannel()){

            channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);
            AMQP.BasicProperties headers = null;

            int n = 10;
            for(int i=0;i<n;i++) {
                Thread.sleep(1000);
                String body = i+"; Test message "+ new Date();
                channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY2, headers, body.getBytes());
                System.out.println(i+" message was published");
            }
        }

        connection.close();

    }

}
