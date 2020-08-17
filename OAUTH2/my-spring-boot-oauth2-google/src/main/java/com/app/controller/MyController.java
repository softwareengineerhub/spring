package com.app.controller;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@EnableOAuth2Sso
public class MyController {

    //also needs to path auth
    @GetMapping("/info")
    public String info(){
        return "info";
    }

    @GetMapping("/roles")
    public String roles(Principal principal){
        OAuth2Authentication userData = (OAuth2Authentication) principal;
        return "userData.getAuthorities()="+userData.getAuthorities();
    }

    @GetMapping("/personalpage")
    public String message(Principal principal) {
        return "Hi "+principal.getName()+"; principal"+principal;
    }

}
