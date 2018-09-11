/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service;

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
public class Sample {

    public static void main(String[] args) throws Exception {
        RestTemplate template = new RestTemplate();
        template.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("X-Tenant-Name", "default");
        RequestEntity<String> requestEntity = new RequestEntity<String>(headers, HttpMethod.GET, new URI("http://localhost:8081/spring-data-rest/api/v1/header/readheader"));
        ResponseEntity<String> stringResponseEntity = template.exchange(requestEntity, String.class);
        System.out.println(stringResponseEntity.getBody());
        template.exchange(requestEntity, String.class);
        
      
    }

}
