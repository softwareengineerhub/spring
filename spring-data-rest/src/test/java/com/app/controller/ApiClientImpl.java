/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.net.URI;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Denys.Prokopiuk
 */
public class ApiClientImpl implements ApiClient {

    private String url;

    public ApiClientImpl(String url) {
        this.url = url;
    }

    public ApiClientImpl() {
        this("http://localhost:8081/spring-data-rest/api/v1");
    }

    @Override
    public int count() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url + "/count", Integer.class);
    }

    @Override
    public List<MyEmployee> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, List.class);
    }

    @Override
    public void save(MyEmployee employee) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForLocation(url, employee);
    }

    @Override
    public MyEmployee get(int id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url + "/" + id, MyEmployee.class);
    }

    @Override
    public void bulkSave(List<MyEmployee> employees) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForLocation(url + "/bulk", employees);
    }

    @Override
    public void update(int id, MyEmployee candidat) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(url + "/" + id, candidat);
    }

    @Override
    public void delete(int id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(url + "/" + id);
    }

    @Override
    public void callWithParams(Map<String, String> params) {
        try {
            RestTemplate template = new RestTemplate();
            StringBuilder query = new StringBuilder();      
            for(String key:params.keySet()){
                query.append(key+"="+params.get(key));
                query.append("&");
            }
            query.deleteCharAt(query.length()-1);
            String resp = template.getForObject(url+"/"+query, String.class);
            System.out.println(resp);            
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void callWithHeaders(Map<String, String> params) {
        try {
            RestTemplate template = new RestTemplate();
            template.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
            for (String key : params.keySet()) {
                headers.add(key, params.get(key));
            }
            RequestEntity<String> requestEntity = new RequestEntity<String>(headers, HttpMethod.GET, new URI(url));
            ResponseEntity<String> stringResponseEntity = template.exchange(requestEntity, String.class);
            System.out.println(stringResponseEntity.getBody());
            // template.exchange(requestEntity, String.class);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
