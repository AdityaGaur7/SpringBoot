package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    
	
	
	@RequestMapping("/")
	public String greet() {
		
		System.out.print("ok");
		
		return "Hello World!!!";
	}

	@RequestMapping("/about")
	public String about() {
		return "This is a simple Spring Boot application.";
	}
}
