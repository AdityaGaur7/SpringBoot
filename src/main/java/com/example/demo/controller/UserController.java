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

    @GetMapping("/csrf-token")
    public CsrfToken getCsrf(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
        }

        @PostMapping("/register")
        public User register(@RequestBody User user) {
        try {
            if (userService.existsByUsername(user.getUsername())) {
            throw new Exception("User already exists");
            }
            return userService.register(user);
        } catch (Exception e) {
            // Log the error and return a meaningful message or null
            System.err.println("Error during registration: " + e.getMessage());
            return null;
        }
        }

        @PostMapping("/login")
        public String login(@RequestBody User user) {
        try {
            return userService.login(user);
        } catch (Exception e) {
            // Log the error and return a meaningful message
            System.err.println("Error during login: " + e.getMessage());
            return "Login failed";
        }
    }
}
