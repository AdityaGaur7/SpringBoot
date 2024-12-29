package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {
    @Autowired
	ProductService productService;

	@GetMapping("/products")
	public ResponseEntity<List<Product>> getProducts() {
		return new ResponseEntity<>(productService.getProducts(),HttpStatus.OK);
	}

	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable int id) {

		Product product = productService.getProductById(id);
		if(product != null) {
			return new ResponseEntity<>(product,HttpStatus.OK);
		}else
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping("/products")
	public void addProduct(@RequestBody Product product) {
		productService.addProduct(product);
	}
    @PutMapping("/products/{id}")
	public void updateProduct(@RequestBody Product product, @PathVariable int id) {
		productService.updateProduct(id, product);
	}

	@DeleteMapping("/products/{id}")
	public void deleteProduct(@PathVariable int id) {
		productService.deleteProduct(id);
	}


	
	
}
