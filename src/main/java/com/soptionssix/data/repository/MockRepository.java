package com.soptionssix.data.repository;

import com.soptionssix.data.document.MockDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MockRepository extends MongoRepository<MockDocument, String> {

}
