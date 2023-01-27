package com.app03.fanout;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

public class PublisherFanOut {

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection("app:api:rest");

        try(Channel channel = connection.createChannel()){
            String exchange ="quotes_exchange";
            channel.exchangeDeclare(exchange, BuiltinExchangeType.FANOUT);


            String routingKey = "";
            AMQP.BasicProperties headers = null;

            int n = 1;
            for(int i=0;i<n;i++) {
                Thread.sleep(1000);
                String body = i+"; Test message "+ new Date();
                channel.basicPublish(exchange, routingKey, headers, body.getBytes());
                System.out.println(i+" message was published");
            }
        }

        connection.close();

    }

}
