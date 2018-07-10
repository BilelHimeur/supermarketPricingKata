package com.zsoft.supermarketpricing.services;

import com.zsoft.supermarketpricing.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PricingService {

    private ProductService productService;


    @Autowired
    public PricingService(ProductService productService) {
        this.productService = productService;
    }

    public double getSimplePrice(long productId, int quantity) throws ProductNotFoundException {
        return productService.getProductById(productId)
                .map(p -> p.getPrice().getValue() * quantity)
                .orElseThrow(() -> new ProductNotFoundException(productId));
    }

}
