package com.soptionssix.data.repository;

import com.soptionssix.data.document.ReferenceDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReferenceRepository extends MongoRepository<ReferenceDocument, String> {

}
