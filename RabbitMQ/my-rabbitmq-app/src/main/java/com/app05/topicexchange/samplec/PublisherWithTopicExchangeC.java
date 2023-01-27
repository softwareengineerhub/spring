package com.app05.topicexchange.samplec;

import com.rabbitmq.client.*;

import java.util.Date;

public class PublisherWithTopicExchangeC {

    private static String EXCHANGE_NAME = "quotes_exchange_topic";
    private static String ROUTING_KEY = "insurance.car.low";
    private static String ROUTING_KEY2 = "insurance.car.high";
    private static String ROUTING_KEY3 = "insurance.car";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection("app:api:rest");

        try(Channel channel = connection.createChannel()){

            channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC);
            AMQP.BasicProperties headers = null;

            int n = 1;
            for(int i=0;i<n;i++) {

                String body = i+"; Test message "+ new Date();
                channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY, headers, body.getBytes());
                System.out.println(i+" message was published to ROUTING_KEY="+ROUTING_KEY);
                Thread.sleep(1000);
                channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY2, headers, body.getBytes());
                System.out.println(i+" message was published to ROUTING_KEY2="+ROUTING_KEY2);
                Thread.sleep(1000);
                channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY3, headers, body.getBytes());
                System.out.println(i+" message was published to ROUTING_KEY3="+ROUTING_KEY3);

            }
        }

        connection.close();

    }

}
