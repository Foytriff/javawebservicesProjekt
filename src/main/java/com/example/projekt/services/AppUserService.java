package com.example.projekt.services;

import com.example.projekt.entities.AppUser;
import com.example.projekt.repositories.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserService {

    @Autowired
    private AppUserRepo appUserRepo;


    public List<AppUser> findAll(){
        List<AppUser> users = appUserRepo.findAll();
        return users;
    }

    public AppUser saveUser(AppUser appUser){
        return appUserRepo.save(appUser);
    }

}
