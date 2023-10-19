package com.app.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/my")
public class MyController {

    @GetMapping
    @PreAuthorize("hasAuthority('STUDENT') or hasAuthority('PROFESSOR')")
    public String get(){
        return "/my-SUCCESS";
    }

}
