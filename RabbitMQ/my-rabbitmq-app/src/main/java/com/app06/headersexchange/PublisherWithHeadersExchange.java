package com.app06.headersexchange;

import com.rabbitmq.client.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class PublisherWithHeadersExchange {

    private static String EXCHANGE_NAME = "quotes_exchange_headers";
    private static String ROUTING_KEY = "";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection("app:api:rest");

        try(Channel channel = connection.createChannel()){

            channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.HEADERS);
            Map headersMap = new HashMap();
            headersMap.put("insurance", "car");
            headersMap.put("type", "business");
            AMQP.BasicProperties headers = new AMQP.BasicProperties.Builder().headers(headersMap).build();

            int n = 1;
            for(int i=0;i<n;i++) {

                String body = i+"; Test message "+ new Date();
                channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY, headers, body.getBytes());
                System.out.println(i+" message was published to ROUTING_KEY="+ROUTING_KEY+"; headers="+headers);
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
