package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepo;

@Service
public class ProductService {

	// List<Product> products  = new ArrayList<>(Arrays.asList(
	// 		new Product(1, "Laptop", 1000),
	// 		new Product(2, "Mobile", 500),
	// 		new Product(3, "Tablet", 300)
	// 		));
             @Autowired
          private ProductRepo repo;

            public List<Product> getProducts() {
                return repo.findAll();
            }

            public Product getProductById(int id) {
                return repo.findById(id).orElse(null);
             }

            public void addProduct(Product product) {
                repo.save(product);
            }
            public void updateProduct( int id,Product product) {
                Product p = repo.findById(id).orElse(null);
                if (p != null) {
                    p.setProdName(product.getProdName());
                    p.setPrice(product.getPrice());
                    repo.save(p);
                } else
                System.out.println("Product not found");   


            }

            public void deleteProduct(int id) {
                repo.deleteById(id);

            }

            public List<Product> searchProducts(String keyword) {
                return repo.searchProducts(keyword);
            }



    
}
