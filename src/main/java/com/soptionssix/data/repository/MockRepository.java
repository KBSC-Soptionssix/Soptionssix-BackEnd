package com.soptionssix.data.repository;

import com.soptionssix.data.document.MockDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MockRepository extends MongoRepository<MockDocument, String> {
}
