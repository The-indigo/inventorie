package com.ajdeyemi.inventorie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajdeyemi.inventorie.models.Products;

public interface ProductsRepository extends JpaRepository<Products, Integer> {
    public Products findByProductName(String name);
}
