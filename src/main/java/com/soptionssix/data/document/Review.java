package com.soptionssix.data.document;


import com.soptionssix.api.param.ReceiptParam;
import com.soptionssix.api.param.ReviewParam;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(value = "review")
@Getter
public class Review {

    @Id
    private String id;

    @DocumentReference(collection = "user", lazy = true)
    private User user;

    @DocumentReference(collection = "receipt", lazy = true)
    private Receipt receipt;

    private String region;
    private String content;

    private List<String> photos;
    private Long createdAt;

    protected Review(
        User user,
        Receipt receipt,
        String region,
        String content,
        List<String> photos
    ) {
        long currentTime = new Date().getTime() / 1000L;
        this.user = user;
        this.receipt = receipt;
        this.region = region;
        this.content = content;
        this.photos = photos;
        this.createdAt = currentTime;
    }

    public static Review of(
        User user,
        Receipt receipt,
        ReviewParam reviewParam
    ) {
        return new Review(
            user,
            receipt,
            reviewParam.region(),
            reviewParam.content(),
            reviewParam.photo()
        );
    }
}
