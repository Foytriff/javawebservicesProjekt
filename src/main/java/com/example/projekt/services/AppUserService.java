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
        return appUserRepo.findAll();
    }

    public List<AppUser> findAll(String contains){
        return appUserRepo.findAppUsersByNameContaining(contains).orElseThrow();
    }

    public AppUser saveUser(AppUser appUser){
        return appUserRepo.save(appUser);
    }

    public AppUser findAppUserById(int id) {
        return appUserRepo.findAppUserById(id).orElseThrow();
    }

    public AppUser updateAppUserById(int id, AppUser changedAppUser) {

        AppUser appUser = this.findAppUserById(id);

        appUser = changedAppUser;

        return this.saveUser(appUser);

    }


}
