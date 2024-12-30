package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.demo.model.User;
import com.example.demo.model.UserPrincipal;
import com.example.demo.repository.UserRepo;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;
    
    @Override   
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        User  user = userRepo.findByUsername(username);
 
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new UserPrincipal(user);





    }

}
