package com.app.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @GetMapping
    @PreAuthorize("hasAuthority('PROFESSOR')")
    public String get(Principal principal){
        return "/professor-SUCCESS; "+principal.getName();
    }

}
