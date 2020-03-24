package com.denistech.jwt.api.controller;

import com.denistech.jwt.api.entity.AuthRequest;
import com.denistech.jwt.api.nats.NatsService;
import com.denistech.jwt.api.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private NatsService natsService;

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to site!";
    }

    /*@PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
        return jwtUtil.generateToken(authRequest.getUserName());
    }*/

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest){
        System.out.println("authRequest="+authRequest);
        System.out.println("authRequest.getUsername()="+authRequest.getUserName());
        System.out.println("authRequest.getPassword()="+authRequest.getPassword());
        boolean isSuccess = natsService.isValidToken(authRequest.getUserName(), authRequest.getPassword());
        if(isSuccess){
            return jwtUtil.generateToken(authRequest.getUserName());
        }
       // authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getPassword(), authRequest.getUsername()));
        throw new RuntimeException("inavalid username/password");
    }

}
