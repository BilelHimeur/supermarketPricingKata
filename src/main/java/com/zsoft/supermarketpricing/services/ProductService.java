package com.zsoft.supermarketpricing.services;

import com.zsoft.supermarketpricing.models.Product;
import com.zsoft.supermarketpricing.persistence.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<Product> getProductById(long productId) {
        return null;
    }
}
