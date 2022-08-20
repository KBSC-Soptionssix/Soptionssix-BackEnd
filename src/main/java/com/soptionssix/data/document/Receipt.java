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
    private final User user;

    @DocumentReference(db = "store")
    private final Store store;

    @DocumentReference(db = "product")
    private final Product product;

    @DocumentReference(db = "review")
    private Review review;

    private final int productCount;
    private final Long date;
    private final Long pickUpTime;
    private final String paymentMethod;
    private final boolean isChallenge;
    private final boolean isDonate;

    public Receipt(
        User user, Product product, int productCount, Long pickUpTime,
        String paymentMethod, boolean isChallenge, boolean isDonate
    ) {
        this.user = user;
        this.store = product.getStore();
        this.product = product;
        this.productCount = productCount;
        this.date = System.currentTimeMillis() / 1000L;
        this.pickUpTime = pickUpTime;
        this.paymentMethod = paymentMethod;
        this.isChallenge = isChallenge;
        this.isDonate = isDonate;
    }

    public void setReview(Review review) {
        this.review = review;
    }
}
