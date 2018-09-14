package com.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@RestController
public class MyController {

    @GetMapping(value = "/api/user")
    public String getContent(Principal principal){
        return "You are inside, user: "+principal.getName();
    }

    @GetMapping(value = "/api/open")
    public String getOpenApi(){
        return "Open api";
    }

    @GetMapping(value = "/api/admin")
    public String getAdmin(){
        return "Admin api";
    }

    @GetMapping(value = "/api/all")
    public String getAll(Principal principal){
        return "All api";
    }

    @GetMapping(value = "/api/user-admin")
    public String getUserAdmin(){
        return "User Admin api";
    }

    @GetMapping(value = "/api/logout")
    public void logout(HttpSession session){
        if(session!=null){
            session.invalidate();
        }
    }

}
