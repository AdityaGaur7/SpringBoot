package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public String user() {
        return userService.getUsers();
    }

    @GetMapping("/csrf-token")
     public CsrfToken getCsrf(HttpServletRequest request) {
   
        return (CsrfToken) request.getAttribute("_csrf");
} 

    @PostMapping("/register")
    public User Register(@RequestBody User user) {
      
        
        return userService.register(user);
    }
   
}
