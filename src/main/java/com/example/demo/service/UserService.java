package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;


    public String getUsers() {
        return userRepo.findAll().toString();
    }
    public User register(User user) {
        return userRepo.save(user);
    }
}
