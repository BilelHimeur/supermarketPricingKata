package com.zsoft.supermarketpricing.services;

import com.zsoft.supermarketpricing.SupermarketPricingApplication;
import com.zsoft.supermarketpricing.exceptions.FormulaNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.zsoft.supermarketpricing.models.enums.Formula.THREE_FOR_A_DOLLAR;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SupermarketPricingApplication.class)
public class FormulaServiceTest {

    @Autowired
    private FormulaService formulaService;

    @Test
    public void getCustomPricerByFormulaTest() throws FormulaNotFoundException {
        //  when
        Double price = formulaService.getCustomPricerByFormula(THREE_FOR_A_DOLLAR).apply(7, 2.0);
        //  then
        assertThat(price, is(4.0));
    }


}