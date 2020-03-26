package com.denistech.jwt.api.nats;

import io.nats.client.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.util.Arrays;

@Component
public class NatsService {
    @Value("${nats.subject.name}")
    private String subjectName;
    @Value("${nats.url}")
    private String natsUrl;
    @Value("${nats.success.message}")
    private String successMessage;
    @Value("${nats.notsuccess.message}")
    private String notSuccessMessage;
    @Value("${nats.valid.username}")
    private String validUsername;
    @Value("${nats.valid.password}")
    private String validPassword;

    private Connection natsConnection;

    @PostConstruct
    public void init() throws Exception {
        natsConnection = Nats.connect(natsUrl);
        AsyncSubscription asyncSubscription = natsConnection.subscribe(subjectName, new MessageHandler() {

                    @Override
                    public void onMessage(Message message) {
                        System.out.println("Validation service consumed message: " + message);
                        try {
                            String dataMessage = new String(message.getData());
                            String[] array = dataMessage.split(";");
                            System.out.println("@@@Consumer: " + Arrays.toString(array));
                            if (validUsername.equals(array[0]) && validPassword.equals(array[1])) {
                                natsConnection.publish(message.getReplyTo(), successMessage.getBytes());
                            } else {
                                natsConnection.publish(message.getReplyTo(), notSuccessMessage.getBytes());
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
    }

    public boolean isValidToken(String username, String password) {
        Connection natsConnection = null;
        try {
            natsConnection = Nats.connect(natsUrl);
            String dataMessage = username + ";" + password;
            Message reply = natsConnection.request(subjectName, dataMessage.getBytes(), 7000);
            if (reply == null) {
                return false;
            }
            String content = new String(reply.getData());
            System.out.println("Reply: " + content);
            return successMessage.equals(content);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
            // throw new RuntimeException(ex);
        } finally {
            if (natsConnection != null) {
                natsConnection.close();
            }
        }
    }

    @PreDestroy
    public void destroy() {
        if (natsConnection != null) {
            natsConnection.close();
        }
    }

}
