package com.tecsup.minishop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tecsup.minishop.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByNameContainingIgnoreCase(String name);
}