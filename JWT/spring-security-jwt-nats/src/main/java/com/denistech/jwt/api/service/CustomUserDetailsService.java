package com.denistech.jwt.api.service;

import com.denistech.jwt.api.entity.User;
import com.denistech.jwt.api.nats.NatsService;
import com.denistech.jwt.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private NatsService natsService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("!!!!!!!!!!!!!loadUserByUsername()!!!!!!!!!!!!!!!!!!!!!!!!!!!1");
        User user = repository.findByUsername(username);
        System.out.println(user);
        //String password = "1";
        boolean natsValidation = natsService.isValidToken(username, user.getPassword());
        System.out.println("natsValidation="+natsValidation);
        return new org.springframework.security.core.userdetails.User(user.getUsername(), "", new ArrayList<>());
    }
}
