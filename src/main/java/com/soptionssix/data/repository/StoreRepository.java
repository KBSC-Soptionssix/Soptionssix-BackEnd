package com.soptionssix.data.repository;

import com.soptionssix.data.document.Receipt;
import com.soptionssix.data.document.Store;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StoreRepository extends MongoRepository<Store, String> {

}

