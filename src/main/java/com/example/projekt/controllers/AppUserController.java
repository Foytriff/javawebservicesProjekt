package com.example.projekt.controllers;


import com.example.projekt.entities.AppUser;
import com.example.projekt.entities.Post;
import com.example.projekt.services.AppUserService;
import com.example.projekt.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/appuser")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private PostService postService;

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

    @GetMapping("/{userId}/posts")
    public List<Post> getPostsForAppUserByAppUserId(@PathVariable int userId){
        return postService.findPostsByAppUserId(userId);
    }

    @PostMapping
    public AppUser saveUser(@RequestBody AppUser appUser){
        return appUserService.saveUser(appUser);
    }

    @PatchMapping("/{id}")
    public AppUser udpateUser(@PathVariable int id, @RequestBody AppUser changedAppUser){

        return appUserService.updateAppUserById(id, changedAppUser);

    }

    @DeleteMapping("/{id}")
    public AppUser deleteUser(@PathVariable int id){
        return appUserService.deleteUserById(id);
    }

}
