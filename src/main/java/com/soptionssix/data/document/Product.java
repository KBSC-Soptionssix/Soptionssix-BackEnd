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
    private String store;

    private String photo;
    private String name;
    private int stockCount;
    private int price;
    private int discount;
    private int donationCompleteCount;
    private int donationWaitCount;

    public Product(
        String store, String photo, String name, int stockCount, int price, int discount
    ) {
        this.store = store;
        this.photo = photo;
        this.name = name;
        this.stockCount = stockCount;
        this.price = price;
        this.discount = discount;
        this.donationCompleteCount = 0;
        this.donationWaitCount = 0;
    }

    public Product(String store, String name, int stockCount, int price, int discount) {
        this(store, null, name, stockCount, price, discount);
    }


    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public void setDonationCompleteCount(int donationCompleteCount) {
        this.donationCompleteCount = donationCompleteCount;
    }

    public void setDonationWaitCount(int donationWaitCount) {
        this.donationWaitCount = donationWaitCount;
    }
}
