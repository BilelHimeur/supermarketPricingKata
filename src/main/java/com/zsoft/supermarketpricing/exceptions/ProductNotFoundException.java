package com.zsoft.supermarketpricing.exceptions;

public class ProductNotFoundException extends Exception {
    private Long productId;

    public ProductNotFoundException(Long productId) {
        super(String.format("No product found with productId %d", productId));
        this.productId = productId;
    }
}
