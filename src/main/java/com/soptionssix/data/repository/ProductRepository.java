package com.soptionssix.data.repository;

import com.soptionssix.data.document.Product;
import com.soptionssix.data.document.Store;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {


    List<Product> findByDonationWaitCountGreaterThan(int donationWaitCount);

    List<Product> findByStore(Store store);
}
