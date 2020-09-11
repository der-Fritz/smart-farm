package com.baya.smartfarm.product.service;


import com.baya.smartfarm.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByName(String name);

    Optional<Product> findByProductCode(String productCode);
}
