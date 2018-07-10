package com.zsoft.supermarketpricing.services;

import com.zsoft.supermarketpricing.SupermarketPricingApplication;
import com.zsoft.supermarketpricing.models.Price;
import com.zsoft.supermarketpricing.models.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static com.zsoft.supermarketpricing.models.enums.Unit.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SupermarketPricingApplication.class)
public class PricingServiceTest {

    @Autowired
    private PricingService pricingService;

    @MockBean
    private ProductService productService;

    @Test
    public void getSimplePriceTest() throws Exception {
        // given
        Long productId = 111L;
        String productName = "product1";
        Price unitPrice = new Price(2.5, UNIT);
        int quantity = 3;
        Product product = new Product();
        product.setId(productId);
        product.setName(productName);
        product.setPrice(unitPrice);
        when(productService.getProductById(productId)).thenReturn(Optional.of(product));

        // when
        double price = pricingService.getSimplePrice(productId, quantity);

        // then
        assertThat(price, is(2.5 * 3));
    }


}