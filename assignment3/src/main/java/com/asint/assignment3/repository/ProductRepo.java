package com.asint.assignment3.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asint.assignment3.model.Product;

public interface ProductRepo extends JpaRepository<Product, Serializable> {

}

