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

        AppUser appUser = this.findAppUserById(id); //hur mycket logik krävs egentligen här? Förutsatt att man vill kunna
                                                    // ändra ganska mycket i sin appuser

        if (changedAppUser.getName() != null){
            appUser.setName(changedAppUser.getName());
        }

        return this.saveUser(appUser);

    }


    public AppUser deleteUserById(int id) {
        AppUser deletedUser = this.findAppUserById(id);
        appUserRepo.deleteById(id);
        return deletedUser;
    }
}
