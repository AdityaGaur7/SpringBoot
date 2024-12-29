package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class LoginController {
    @RequestMapping("/login")
    public String login() {
        return "This is the login page.";
    }
}
