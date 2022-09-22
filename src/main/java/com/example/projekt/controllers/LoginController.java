package com.example.projekt.controllers;

import com.example.projekt.DTOs.JwtRequestDTO;
import com.example.projekt.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public String authenticate(@RequestBody JwtRequestDTO jwtRequestDTO){
        return loginService.authenticate(jwtRequestDTO);
    }

}
