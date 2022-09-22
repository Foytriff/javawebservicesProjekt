package com.example.projekt.security;

import com.example.projekt.entities.AppUser;
import com.example.projekt.repositories.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AppUserRepo appUserRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AppUser appUser = appUserRepo.findAppUserByUsername(username);


        return User.builder()
                .username(appUser.getUsername())
                .password(passwordEncoder.encode(appUser.getPassword())) //kanske inte encoda här, utan gör det i commandlinerunner i app?
                .authorities(new SimpleGrantedAuthority("ROLE_ADMIN"))
                .build();
    }
}