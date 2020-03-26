package com.denistech.jwt.api.controller;

import com.denistech.jwt.api.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class WelcomeController {

    //@Autowired
    //private JwtUtil jwtUtil;

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to site!";
    }

    @PostMapping("/authenticate")
    public String generateToken(Principal principal, Authentication authentication){
        return principal.getName();
    }

    /*@PostMapping("/authenticate")
    public String generateToken(Principal principal, Authentication authentication){
        Object customCredential = SecurityContextHolder.getContext().getAuthentication().getCredentials();
        System.out.println("customCredential="+customCredential);
        System.out.println("SecurityContextHolder.getContext().hashCode="+SecurityContextHolder.getContext().hashCode());
        UsernamePasswordAuthenticationToken res = (UsernamePasswordAuthenticationToken) authentication;
        System.out.println("credentials.hashCode="+res.hashCode());
        System.out.println("credentials="+res.getCredentials());
        //System.out.println("userDetails:"+userDetails);
        System.out.println("authentication:"+authentication);
        String name = authentication.getName();
        //String password = authentication.getCredentials().toString();
        System.out.println("name="+name);
        //System.out.println("password="+password);
        return jwtUtil.generateToken(principal.getName(), "1");
        //return jwtUtil.generateToken(name, password);
    }*/

    /*@PostMapping("/authenticate")
    public String generateToken(){
        return "POST-Success";
    }*/

/*    @GetMapping("/authenticate")
    public String generateToken2(){
        return "GET-Success";
    }*/


}
