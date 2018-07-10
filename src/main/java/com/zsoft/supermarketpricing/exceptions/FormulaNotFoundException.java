package com.zsoft.supermarketpricing.exceptions;

import com.zsoft.supermarketpricing.models.enums.Formula;

public class FormulaNotFoundException extends Exception {
    private Formula formula;

    public FormulaNotFoundException(Formula formula) {
        super(String.format("No formula found with name %s", formula.name()));
        this.formula = formula;
    }
}
