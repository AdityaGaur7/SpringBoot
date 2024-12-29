package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ProductController {
    @Autowired
	ProductService productService;

	@GetMapping("/products")
	public List<Product> getProducts() {
		return productService.getProducts();
	}
	
	
}
