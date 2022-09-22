package com.example.projekt.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

@Service
public class JwtUtils {

    public String generateToken(String username){
        return Jwts.builder()
                .setSubject(username)
                .signWith(SignatureAlgorithm.HS512, "berattaintefornogon") // funkar inte med E..263?... varför?
                .compact();
    }

    public boolean validate(String token) {
        try {
            Jwts.parser().setSigningKey("berattaintefornogon").parseClaimsJws(token);
            return true;
        } catch (Exception e){
            return false;
        }

    }
}
