package com.soptionssix.data.repository;

import com.soptionssix.data.document.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepository extends MongoRepository<Review, String> {

}
