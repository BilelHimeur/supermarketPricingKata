package com.zsoft.supermarketpricing.utils;

import com.zsoft.supermarketpricing.SupermarketPricingApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.zsoft.supermarketpricing.models.enums.Unit.OUNCE;
import static com.zsoft.supermarketpricing.models.enums.Unit.POUND;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SupermarketPricingApplication.class)
public class UnitConvertorTest {

    @Autowired
    private UnitConvertor unitConvertor;

    @Test
    public void testConversion() {

        // when
        Float onePoundToOunce = unitConvertor.apply(POUND, OUNCE);

        Float oneOunceToPound = unitConvertor.apply(OUNCE, POUND);

        // then
        assertThat(onePoundToOunce, is(16F));
        assertThat(oneOunceToPound, is(1 / 16F));

    }


}