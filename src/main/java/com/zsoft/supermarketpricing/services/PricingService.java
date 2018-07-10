package com.zsoft.supermarketpricing.services;

import com.zsoft.supermarketpricing.exceptions.ProductNotFoundException;
import com.zsoft.supermarketpricing.models.Product;
import com.zsoft.supermarketpricing.models.enums.Formula;
import com.zsoft.supermarketpricing.models.enums.Unit;
import com.zsoft.supermarketpricing.utils.UnitConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PricingService {

    private ProductService productService;
    private UnitConvertor convertor;


    @Autowired
    public PricingService(ProductService productService) {
        this.productService = productService;
    }

    public double getSimplePrice(long productId, int quantity) throws ProductNotFoundException {
        return productService.getProductById(productId)
                .map(p -> p.getPrice().getValue() * quantity)
                .orElseThrow(() -> new ProductNotFoundException(productId));
    }

    public double getPriceByWeight(long productId, Float weight, Unit unit) throws ProductNotFoundException {
        Product product = productService.getProductById(productId).orElseThrow(() -> new ProductNotFoundException(productId));
        return product.getPrice().getValue() * convertor.apply(unit, product.getPrice().getUnit()) * weight;
    }

    public double getPriceUsingFormula(long productId, Integer quantity, Formula formula) {
        return 0.0;
    }

}