package com.soptionssix.data.document;

import lombok.Getter;
import lombok.Setter;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value="product")
@Getter
@Setter
public class Product {
    @Id
    private String id;

    private String store;

    private String photo;
    private String name;
    private int stockCount;
    private int price;
    private int discount;
    private int donationCompleteCount;
    private int donationWaitCount;

}
