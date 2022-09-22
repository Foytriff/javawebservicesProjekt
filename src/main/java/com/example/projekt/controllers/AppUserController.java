package com.example.projekt.controllers;


import com.example.projekt.entities.AppUser;
import com.example.projekt.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/appuser")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @GetMapping("/welcome")
    public String welcomeMessage(){
        return "Hello, World";
    }

    @GetMapping
    public List<AppUser> findAll(@RequestParam(required = false, defaultValue = "") String contains){
        return appUserService.findAll(contains);
    }

    @GetMapping("/{id}")
    public AppUser getAppUser(@PathVariable int id){
        return appUserService.findAppUserById(id);
    }

    @PostMapping
    public AppUser saveUser(@RequestBody AppUser appUser){
        return appUserService.saveUser(appUser);
    }

    @PatchMapping
    public AppUser saasdf(){return new AppUser();}

}
