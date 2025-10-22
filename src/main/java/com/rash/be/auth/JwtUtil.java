package com.rash.be.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Objects;

@Component

public class JwtUtil {
    private final SecretKey key;
    private final long expirationMs;

/*    public JwtUtil(@Value("${jwt.secret}") String secret,
                   @Value("${jwt.expirationMs}" long expirationMs)){
        this.key= Keys.hmacShaKeyFor(secret.getBytes());
        this.expirationMs=expirationMs;

    }*/
    public String generateToken(org.springframework.security.core.userdetails.UserDetails userDetails){
        Date now=new Date();
        Date expiry= new Date(now.getTime()+ expirationMs);
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .claim("roles", userDetails.getAuthorities().stream()
                        .map(Objects::toString).toList())
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

    }
    public String getUsernameFromToken(String token){
        Claims claims= Jwts.parserBuilder().setSigningKey(key).build()
                .parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    public boolean validateToken(String token){
        try{
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        }catch (JwtException | IllegalArgumentException ex){
            return false;
        }
    }
}
