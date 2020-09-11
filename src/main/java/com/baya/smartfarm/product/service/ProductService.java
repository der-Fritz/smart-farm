package com.baya.smartfarm.product.service;

import com.baya.smartfarm.product.Product;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    Product register(Product product);

    Product update(Product product);

    Product delete(Product product);

    Long total();

    List<Product> findAll(Pageable pageable);

}
