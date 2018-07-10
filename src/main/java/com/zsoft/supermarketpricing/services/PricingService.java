package com.zsoft.supermarketpricing.services;

import com.zsoft.supermarketpricing.exceptions.FormulaNotFoundException;
import com.zsoft.supermarketpricing.exceptions.ProductNotFoundException;
import com.zsoft.supermarketpricing.models.Product;
import com.zsoft.supermarketpricing.models.enums.Formula;
import com.zsoft.supermarketpricing.models.enums.Unit;
import com.zsoft.supermarketpricing.utils.UnitConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.BiFunction;


@Service
public class PricingService {

    private ProductService productService;
    private UnitConvertor convertor;
    private FormulaService formulaService;

    @Autowired
    public PricingService(ProductService productService, UnitConvertor convertor, FormulaService formulaService) {
        this.productService = productService;
        this.convertor = convertor;
        this.formulaService = formulaService;
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

    public double getPriceUsingFormula(long productId, Integer quantity, Formula formula) throws FormulaNotFoundException, ProductNotFoundException {
        Product product = productService.getProductById(productId).orElseThrow(() -> new ProductNotFoundException(productId));
        BiFunction<Integer, Double, Double> customPricerByFormula = formulaService.getCustomPricerByFormula(formula);
        return customPricerByFormula.apply(quantity, product.getPrice().getValue());
    }

}