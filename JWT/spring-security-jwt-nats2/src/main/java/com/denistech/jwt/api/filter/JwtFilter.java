package com.denistech.jwt.api.filter;

import com.denistech.jwt.api.nats.NatsService;
import com.denistech.jwt.api.util.JwtUtil;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private NatsService natsService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("@Start filter");
        String authorizationHeader = httpServletRequest.getHeader("Authorization");
        System.out.println("authorizationHeader="+authorizationHeader);


        //basic auth mechanism
        if(authorizationHeader!=null){
            //byte[] encodedAuth = Base64.encodeBase64(authorizationHeader.getBytes(StandardCharsets.ISO_8859_1));
            //String authHeader = "Basic " + new String(encodedAuth);
            authorizationHeader=authorizationHeader.substring(6);
            System.out.println("\tauthorizationHeader="+authorizationHeader);
            byte[] data = Base64.decodeBase64(authorizationHeader.getBytes(StandardCharsets.ISO_8859_1));
            System.out.println("res="+new String(data));
        }


        String token = null;
        String userName = null;

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            token = authorizationHeader.substring(7);
            userName = jwtUtil.extractUsername(token);
        }

        if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            //String password = SecurityContextHolder.getContext().getAuthentication().getCredentials()+"";
            System.out.println("inside 2 if");
            //natsService.isValidToken(userName, password);
            UserDetails userDetails = jwtUtil.extractUserDetails(token);
            if(natsService.isValidToken(userDetails.getUsername(), userDetails.getPassword())){
                System.out.println("inside 3 if jwtUtil.validateToken");
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                System.out.println("after step1");
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                System.out.println("after step2");
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                System.out.println("after step3");
            }

            /*if (jwtUtil.validateToken(token, userDetails)) {
                System.out.println("inside 3 if jwtUtil.validateToken");
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                System.out.println("after step1");
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                System.out.println("after step2");
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                System.out.println("after step3");
            }*/
        }

        System.out.println("@Before filter.doChain");
        filterChain.doFilter(httpServletRequest, httpServletResponse);
        System.out.println("Infilter.SecurityContextHolder.getContext().hashCode="+SecurityContextHolder.getContext().hashCode());

        System.out.println("@After filter.doChain");
    }
}
