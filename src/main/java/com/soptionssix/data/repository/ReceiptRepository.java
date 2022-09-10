package com.soptionssix.data.repository;

import com.soptionssix.data.document.Receipt;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReceiptRepository extends MongoRepository<Receipt, String> {

    public List<Receipt> findByUser(ObjectId userId);
}
