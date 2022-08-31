package com.soptionssix.data.repository;

import com.soptionssix.data.document.Store;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StoreRepository extends MongoRepository<Store, String> {


}

