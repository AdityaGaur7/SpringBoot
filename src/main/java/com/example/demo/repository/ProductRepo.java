package com.example.demo.repository;
import com.example.demo.model.Product;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

        @Query("SELECT p FROM Product p WHERE LOWER(p.prodName) LIKE LOWER(CONCAT('%', :keyword,'%'))")    
        List<Product> searchProducts(String keyword);
}
