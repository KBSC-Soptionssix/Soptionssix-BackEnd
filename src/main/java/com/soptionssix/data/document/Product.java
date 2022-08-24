package com.soptionssix.data.document;

import lombok.Getter;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(value = "product")
@Getter()
public class Product {

    @Id
    private String id;
    @DocumentReference(db = "store")
    private Store store;

    private String photo;
    private String name;
    private int stockCount;
    private int price;
    private int discount;
    private int donationCompleteCount;
    private int donationWaitCount;

    protected Product() {
    }
}
