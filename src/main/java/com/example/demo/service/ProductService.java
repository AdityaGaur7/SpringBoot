package com.example.demo.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Product;

@Service
public class ProductService {

	List<Product> products  = Arrays.asList(
			new Product(1, "Laptop", 1000),
			new Product(2, "Mobile", 500),
			new Product(3, "Tablet", 300)
			);

            public List<Product> getProducts() {
                return products;
            }
    
}
