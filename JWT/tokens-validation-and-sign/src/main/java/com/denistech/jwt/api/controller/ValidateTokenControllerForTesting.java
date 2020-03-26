package com.denistech.jwt.api.controller;

import com.denistech.jwt.api.util.JwtUtil;
import com.denistech.jwt.api.util.JwtUtil2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ValidateTokenControllerForTesting {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private JwtUtil2 jwtUtil2;

    @GetMapping("/test/getToken")
    public String getToken(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        return jwtUtil.generateToken(username, password);
    }

    @PostMapping("/test/validateToken")
    public String validateToken(HttpServletRequest request){
        String authHeader = request.getHeader("Authorization");
        int n = "Bearer ".length();
        String token = authHeader.substring(n);
        String username = jwtUtil.extractUsername(token);
        return "RESULT:"+username;
    }

    @GetMapping("/test/getToken2")
    public String getToken2(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        return jwtUtil2.generateToken(username, password);
    }

    @PostMapping("/test/validateToken2")
    public String validateToken2(HttpServletRequest request){
        String authHeader = request.getHeader("Authorization");
        int n = "Bearer ".length();
        String token = authHeader.substring(n);
        String username = jwtUtil2.extractUsername(token);
        return "RESULT:"+username;
    }
}
