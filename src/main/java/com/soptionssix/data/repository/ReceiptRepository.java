package com.soptionssix.data.repository;

import com.soptionssix.data.document.Receipt;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReceiptRepository extends MongoRepository<Receipt, String> {

}
