package com.soptionssix.data.repository;

import com.soptionssix.data.document.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

}
