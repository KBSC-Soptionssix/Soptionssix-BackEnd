package com.soptionssix.data.repository;

import com.soptionssix.data.document.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {

}
