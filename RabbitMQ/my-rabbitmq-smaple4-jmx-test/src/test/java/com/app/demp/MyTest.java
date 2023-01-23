package com.app.demp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

@SpringBootTest
public class MyTest {
    private RestTemplate restTemplate = new RestTemplate();
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void test() throws Exception {
        String url = "http://127.0.0.1:15672/api/queues";
        String username = "guest";
        String password = "guest";
        String queueName = "MyQueue";
        QueueStat queueStatBeforePublishing = getStatistics(url, username, password, queueName);
        System.out.println("queueStatBeforePublishing=" + queueStatBeforePublishing);
        //publish();
        Thread.sleep(5000);
        QueueStat queueStatAfterPublishing = getStatistics(url, username, password, queueName);
        System.out.println("queueStatAfterPublishing=" + queueStatAfterPublishing);
    }

    private QueueStat getStatistics(String url, String username, String password, String queueName) throws JSONException {
        String responseBody = read(url, username, password);
        return parseResponse(responseBody, queueName);
    }

    private QueueStat parseResponse(String responseBody, String qName) throws JSONException {
        JSONArray array = new JSONArray(responseBody);
        JSONObject queue = null;
        for (int i = 0; i < array.length(); i++) {
            queue = array.getJSONObject(i);
            if (qName.equals(queue.get("name"))) {
                break;
            }
        }
        JSONObject stats = queue.getJSONObject("message_stats");
        long ack = stats.getLong("ack");
        long publish = stats.getLong("publish");
        return new QueueStat(ack, publish);
    }

    private String read(String url, String username, String password) {
        try {
            String authStr = username + ":" + password;
            String base64Creds = Base64.getEncoder().encodeToString(authStr.getBytes());

            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Basic " + base64Creds);
            HttpEntity request = new HttpEntity(headers);

            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
            return response.getBody();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }


}
