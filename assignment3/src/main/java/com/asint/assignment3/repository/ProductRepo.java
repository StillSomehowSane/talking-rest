package com.asint.assignment3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asint.assignment3.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}

