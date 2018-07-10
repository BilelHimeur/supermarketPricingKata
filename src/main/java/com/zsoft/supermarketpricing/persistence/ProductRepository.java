package com.zsoft.supermarketpricing.persistence;

import com.zsoft.supermarketpricing.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
