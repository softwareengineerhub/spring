package com.app.service;

import com.app.model.Person;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private RestTemplate restTemplate;
    private String url = "http://127.0.0.1:8080/api/v1";

    public void create(Person person, String username, String password) {
        try {
            String authStr = username + ":" + password;
            String base64Creds = Base64.getEncoder().encodeToString(authStr.getBytes());

            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Basic " + base64Creds);
            HttpEntity request = new HttpEntity(person, headers);

            ResponseEntity<String> response = restTemplate.exchange(url + "/person", HttpMethod.POST, request, String.class);
            System.out.println("status-code=" + response.getStatusCodeValue());
            System.out.println("body=" + response.getBody());
        } catch (HttpClientErrorException.Unauthorized ex) {
            System.out.println("401. Unauthorized for query");
        } catch (HttpClientErrorException.Forbidden ex) {
            System.out.println("403. Forbidden for query");
        }
    }

    public List<Person> readAll(String username, String password) {
        try {
            String authStr = username + ":" + password;
            String base64Creds = Base64.getEncoder().encodeToString(authStr.getBytes());

            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Basic " + base64Creds);
            HttpEntity request = new HttpEntity(headers);

            ResponseEntity<String> response = restTemplate.exchange(url + "/person", HttpMethod.GET, request, String.class);
            System.out.println("status-code=" + response.getStatusCodeValue());
            System.out.println("body=" + response.getBody());

            ObjectMapper mapper = new ObjectMapper();
            List<Person> list = mapper.readValue(response.getBody(), new TypeReference<List<Person>>() {
            });

            return list;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public Person readById(int id, String username, String password) {
        try {
            String authStr = username + ":" + password;
            String base64Creds = Base64.getEncoder().encodeToString(authStr.getBytes());

            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Basic " + base64Creds);
            HttpEntity request = new HttpEntity(headers);

            ResponseEntity<Person> response = restTemplate.exchange(url + "/person/id/" + id, HttpMethod.GET, request, Person.class);
            System.out.println("status-code=" + response.getStatusCodeValue());
            System.out.println("body=" + response.getBody());

            /*ObjectMapper objectMapper = new ObjectMapper();
            LinkedHashMap map = objectMapper.readValue(response.getBody(), Person[0].class);
            System.out.println(map);*/

            return response.getBody();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }


    public void info() {
        String response = restTemplate.getForObject(url + "/person/info", String.class);
        System.out.println("info.response=" + response);
    }
}
