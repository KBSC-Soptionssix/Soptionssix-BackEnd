package com.soptionssix.data.document;

import lombok.Getter;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(value = "receipt")
@Getter
public class Receipt {

    @Id
    private String id;

    @DocumentReference(db = "user")
    private User user;

    @DocumentReference(db = "store")
    private Store store;

    @DocumentReference(db = "product")
    private Product product;

    @DocumentReference(db = "review")
    private Review review;

    private int productCount;
    private Long date;
    private Long pickUpTime;
    private String paymentMethod;
    private boolean isChallenge;
    private boolean isDonate;

    protected Receipt() {
    }
}
