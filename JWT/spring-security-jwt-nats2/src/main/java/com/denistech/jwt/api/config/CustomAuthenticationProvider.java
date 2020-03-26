package com.denistech.jwt.api.config;

import com.denistech.jwt.api.nats.NatsService;
import com.denistech.jwt.api.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private NatsService natsService;
    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        System.out.println("Custom!!!!!!!!!!!!!!! name=" + name + "; password=" + password);
        boolean res = natsService.isValidToken(name, password);
        System.out.println("After Nats call!!!!!!!!!!!!!!! res=" + res);
        if(res) {
            String token = jwtUtil.generateToken(name, password);
            UsernamePasswordAuthenticationToken upat = new UsernamePasswordAuthenticationToken(token, null, new ArrayList());
            System.out.println("upat.hashCode()="+upat.hashCode());
            SecurityContextHolder.getContext().setAuthentication(upat);
            System.out.println("SecurityContextHolder.getContext().hashCode="+SecurityContextHolder.getContext().hashCode());
            return upat;
        } else {
            throw new RuntimeException("Not authorized");
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
