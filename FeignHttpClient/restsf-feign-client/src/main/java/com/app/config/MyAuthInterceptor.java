package com.app.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class MyAuthInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        RestTemplate restTemplate = new RestTemplate();
        LinkedMultiValueMap<String, String> requestParameters = new LinkedMultiValueMap();

        requestParameters.add("username","denys.prokopiuk@gmail.com");
        requestParameters.add("password","Jk0508257123tba6OYhSPirFXCDpV4kGqwW8");
        requestParameters.add("grant_type","password");
        requestParameters.add("client_id","3MVG9wEVwV0C9ejAB.lOaJKjz45.lUQW_Ah35zqoeluxqPsKhi3ga4RJYKeXJGSDJhERk2JGgspfjjWIO2amW");
        requestParameters.add("client_secret","B88DD6282EA19A159683913341139B614C2D993D3127D841354F2353FE61D76F");

        Map<String, String> res = restTemplate.postForObject("https://login.salesforce.com/services/oauth2/token", requestParameters, Map.class);
        //System.out.println(res);


        requestTemplate.header("Authorization", String.format("Bearer %s", res.get("access_token")));

    }
}
