package com.soptionssix.data.document;

import com.soptionssix.api.param.ReceiptParam;
import java.util.Date;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(value = "receipt")
@Getter
public class Receipt {

    @Id
    private String id;

    @DocumentReference(collection = "user", lazy = true)
    private User user;

    @DocumentReference(collection = "store", lazy = true)
    private Store store;

    @DocumentReference(collection = "product", lazy = true)
    private Product product;

    @DocumentReference(collection = "review")
    private Review review;

    @NotNull
    private int productCount;
    @NotNull
    private Long date;
    @NotNull
    private Long pickUpTime;
    @NotNull
    private String paymentMethod;
    @NotNull
    private boolean isChallenge;
    @NotNull
    private boolean isDonate;

    protected Receipt(
        User user,
        Store store,
        Product product,
        Review review,
        int productCount,
        Long date,
        Long pickUpTime,
        String paymentMethod,
        boolean isChallenge,
        boolean isDonate
    ) {
        this.user = user;
        this.store = store;
        this.product = product;
        this.review = review;
        this.productCount = productCount;
        this.date = date;
        this.pickUpTime = pickUpTime;
        this.paymentMethod = paymentMethod;
        this.isChallenge = isChallenge;
        this.isDonate = isDonate;
    }

    public static Receipt of(
        User user,
        Store store,
        Product product,
        ReceiptParam receiptParam
    ) {
        long currentTime = new Date().getTime() / 1000L;
        return new Receipt(
            user,
            store,
            product,
            null,
            receiptParam.productCount(),
            currentTime,
            receiptParam.pickUpTime(),
            receiptParam.paymentMethod(),
            receiptParam.isChallenge(),
            receiptParam.isDonate()
        );
    }

    public void addReview(Review review) {
        this.review = review;
    }
}
