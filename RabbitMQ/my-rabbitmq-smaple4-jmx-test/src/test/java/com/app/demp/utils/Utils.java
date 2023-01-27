package com.app.demp.utils;

import com.app.demp.QueueStat;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

public class Utils {


    public static QueueStat getStatistics(String url, String username, String password, String queueName) throws JSONException {
        String responseBody = read(url, username, password);
        return parseResponse(responseBody, queueName);
    }

    private static QueueStat parseResponse(String responseBody, String qName) throws JSONException {
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

    private static String read(String url, String username, String password) {
        try {
            String authStr = username + ":" + password;
            String base64Creds = Base64.getEncoder().encodeToString(authStr.getBytes());

            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Basic " + base64Creds);
            HttpEntity request = new HttpEntity(headers);
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
            return response.getBody();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

}
