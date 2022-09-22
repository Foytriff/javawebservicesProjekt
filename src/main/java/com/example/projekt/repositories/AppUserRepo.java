package com.example.projekt.repositories;

import com.example.projekt.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppUserRepo extends JpaRepository<AppUser, Integer> {

    public Optional<AppUser> findAppUserById(int id);

    public Optional<List<AppUser>> findAppUsersByNameContaining(String contains);

    public AppUser findAppUserByUsername(String username);
}
