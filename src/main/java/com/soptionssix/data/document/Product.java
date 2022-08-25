package com.soptionssix.data.document;

import javax.validation.constraints.NotNull;
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
    @NotNull
    private Store store;
    private String photo;
    @NotNull
    private String name;
    @NotNull
    private int stockCount;
    @NotNull
    private int price;
    @NotNull
    private int discount;
    private int donationCompleteCount;
    private int donationWaitCount;

    protected Product() {
    }
}
