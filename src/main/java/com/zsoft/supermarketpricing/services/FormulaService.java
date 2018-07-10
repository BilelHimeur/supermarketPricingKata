package com.zsoft.supermarketpricing.services;

import com.zsoft.supermarketpricing.exceptions.FormulaNotFoundException;
import com.zsoft.supermarketpricing.models.enums.Formula;
import org.springframework.stereotype.Service;

import java.util.function.BiFunction;

@Service
public class FormulaService {

    public BiFunction<Float, Double, Double> getCustomPricerByFormula(Formula formula) throws FormulaNotFoundException {
        if (formula == null) {
            throw new NullPointerException("formula is null.");
        }
        switch (formula) {
            case THREE_FOR_A_DOLLAR:
                return (quantity, unitPrice) -> quantity.intValue() / 3 + quantity % 3 * unitPrice;
            default:
                throw new FormulaNotFoundException(formula);
        }

    }
}
