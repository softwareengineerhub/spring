package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        //
        //System.setProperty("my.openid.uiClientId", "QQQQQ");
        //System.setProperty("my.openid.uiClient-id", "override1");
        //System.setProperty("my.openid.ui-client-id", "override2");
        //System.setProperty("MY-OPENID-CLIENT-ID", "override3");
        //System.setProperty("MY_OPENID_UI_CLIENT_ID", "override3");
        //System.setProperty("MY_OPENID_UI-CLIENT-ID", "override4");
//        System.setProperty("MY_OPENID_UI_CLIENT_ID", "override4");
       // System.setProperty("MY_OPENID_UI_CLIENT_ID", "override4");
        System.out.println("Read Specific Enviornment Variable");
        System.out.println("JAVA_HOME Value:- " + System.getenv("JAVA_HOME"));
        Map<String, String> map = System.getenv();
        for (Map.Entry <String, String> entry: map.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }

     //   System.setProperty("spring.profiles.active", "service1,service2");
        SpringApplication.run(Main.class, args);
    }
}
