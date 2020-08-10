package com.app.controller;

import com.app.service.SigmupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.security.Principal;

@RestController
@RequestMapping("/api/v2")
public class SimpleController {
    @Autowired
    private SigmupService sigmupService;

    @PostConstruct
    public void init(){
      //  sigmupService.create("test2", "2", "ADMIN");
    }

    @GetMapping("/admin")
    public String admin(Principal principal){
        return "Welcome to admin. Your name is "+principal.getName();
    }

    @GetMapping("/user")
    public String user(Principal principal){

        return "Welcome to user. Your name is "+principal.getName();
    }

    @GetMapping("/user-admin")
    public String userAdmin(Principal principal){
        return "Welcome to user-admin. Your name is "+principal.getName();
    }
}
