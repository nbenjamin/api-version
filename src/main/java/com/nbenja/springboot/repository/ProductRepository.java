package com.nbenja.springboot.repository;

import com.nbenja.springboot.domain.Product;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 */
public interface ProductRepository extends JpaRepository<Product, Integer>{
}
