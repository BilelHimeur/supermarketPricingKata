package com.zsoft.supermarketpricing.services;

import com.zsoft.supermarketpricing.SupermarketPricingApplication;
import com.zsoft.supermarketpricing.models.Product;
import com.zsoft.supermarketpricing.persistence.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SupermarketPricingApplication.class)
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    @Test
    public void getProductByIdTest() throws Exception {
        // given
        Long productId = 111L;
        String productName = "product1";
        Product product = new Product();
        product.setId(productId);
        product.setName(productName);
        when(productRepository.findById(productId)).thenReturn(Optional.of(product));

        // when
        Optional<Product> maybeProduct = productService.getProductById(productId);

        // then
        assertThat(maybeProduct.isPresent(), is(true));
        assertThat(maybeProduct.get().getId(), is(productId));
        assertThat(maybeProduct.get().getName(), is(productName));
    }

}