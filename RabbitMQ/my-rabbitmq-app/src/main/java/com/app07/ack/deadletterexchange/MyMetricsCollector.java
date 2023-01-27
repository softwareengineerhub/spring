package com.app07.ack.deadletterexchange;

import com.rabbitmq.client.*;
import com.rabbitmq.client.impl.StandardMetricsCollector;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MyMetricsCollector {


    private static String QUEUE_NAME = "my-dlq-sample";
    private static String EXCHANGE_NAME = "";
    private static String DLX_EXCHANGE_NAME = "user_dlx";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        //factory.setMetricsCollector(new StandardMetricsCollector());
        Connection connection = factory.newConnection("app:api:rest");


        try(Channel channel = connection.createChannel()){

            Map<String, Object> arguments = new HashMap<>();
            arguments.put("x-dead-letter-exchange", DLX_EXCHANGE_NAME);
            arguments.put("x-dead-letter-routing-key", "user-dlx");

            channel.exchangeDeclare(DLX_EXCHANGE_NAME, BuiltinExchangeType.DIRECT);
            boolean durable = false;
            boolean exclusive = false;
            boolean autoDelete = false;
            channel.queueDeclare(QUEUE_NAME, durable, exclusive, autoDelete, arguments);

            AMQP.BasicProperties headers = null;

            int n = 2;
            for(int i=0;i<n;i++) {

                String body = i+"; Test message "+ new Date();
                channel.basicPublish(EXCHANGE_NAME, QUEUE_NAME, headers, body.getBytes());
                System.out.println(i+" message was published to QUEUE_NAME="+QUEUE_NAME);
                /*Thread.sleep(1000);
                channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY2, headers, body.getBytes());
                System.out.println(i+" message was published to ROUTING_KEY2="+ROUTING_KEY2);
                Thread.sleep(1000);
                channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY3, headers, body.getBytes());
                System.out.println(i+" message was published to ROUTING_KEY3="+ROUTING_KEY3);*/

            }
        }

        connection.close();

    }
}
