package com.example.projekt.services;

import com.example.projekt.DTOs.JwtRequestDTO;
import com.example.projekt.entities.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    PasswordEncoder passwordEncoder;

    public String authenticate(JwtRequestDTO jwtRequestDTO) {

        UserDetails userDetails = userDetailsService.loadUserByUsername(jwtRequestDTO.username());

        if(passwordEncoder.matches(jwtRequestDTO.password(), userDetails.getPassword())){   // userDetails.getPassword().equals(jwtRequestDTO.password()) - Varför inte detta?
            return jwtUtils.generateToken(jwtRequestDTO.username());
        } else {
            return "detgickintesåbra";
        }


    }

    public boolean validate(String token){
        return jwtUtils.validate(token);
    }
}
