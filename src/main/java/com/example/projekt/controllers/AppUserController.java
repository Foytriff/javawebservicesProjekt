package com.example.projekt.controllers;


import com.example.projekt.entities.AppUser;
import com.example.projekt.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("myApi/appuser")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @GetMapping
    public String welcomeMessage(){
        return "Hello, World";
    }

    @GetMapping("/users")
    public List<AppUser> findAll(){
        return appUserService.findAll();
    }

    @PostMapping
    public AppUser saveUser(@RequestBody AppUser appUser){
        return appUserService.saveUser(appUser);
    }

}
