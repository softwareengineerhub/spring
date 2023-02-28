package com.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@RestController
public class MyLogout {


    @GetMapping("/logout")
    public void logout(HttpSession session){
        session.invalidate();
    }
}
