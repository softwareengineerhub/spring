package com.denistech.jwt.api.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtil02 {
    private String secret;

    @PostConstruct
    public void init(){
        for(int i=0;i<256;i++){
            secret=secret+"b";
        }
    }

    public String generateToken(String username, String password, String role) {
        Map<String, Object> map = new HashMap<>();
        map.put("password", password);
        map.put("role", role);
        return createToken(username, map);
    }

    // "alg": "HS256"
    //encoded "test" --> f("test") = "sdgfhfvsfvkdfi095r08t39"
    //decoded "sdgfhfvsfvkdfi095r08t39" --> g("sdgfhfvsfvkdfi095r08t39") = "test"
    private String createToken(String username, Map<String, Object> claims) {
        return Jwts.builder().addClaims(claims).setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60))
                .signWith(SignatureAlgorithm.HS256, secret).compact();
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
        //return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        SecretKey secretKey = getSecretKey();
        return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload();
    }

    private SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }


}
