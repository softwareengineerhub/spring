package com.denistech.jwt.api.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ClaimsMutator;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtil {
    private String secret = "denisch";

    public String generateToken(String username, String password) {
        Map<String, Object> map = new HashMap<>();
        map.put("password", password);
        return createToken(username, map);
    }

    private String createToken(String username, Map<String, Object> claims) {
        return Jwts.builder().addClaims(claims).setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60))
                .signWith(SignatureAlgorithm.HS256, secret).compact();
    }

    public UserDetails extractUserDetails(String token){
        final String username = extractUsername(token);
        final Claims claims = extractAllClaims(token);
        String password = claims.get("password", String.class);
        UserDetails userDetails = new User(username, password, new ArrayList<>());
        return userDetails;
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
       // final Claims claims = extractAllClaims(token);
     //   String password = claims.get("password", String.class);
        if (!userDetails.getUsername().equals(username)) {
            return false;
        }
        return true;
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

}
