package com.soptionssix.data.document;


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
    private final User user;

    @DocumentReference(collection = "receipt", lazy = true)
    private final Receipt receipt;

    private final String region;
    private String content;

    private List<String> photos;
    private long createdAt;

    protected Review(
        User user,
        Receipt receipt,
        String region,
        String content,
        List<String> photos
    ) {
        this.user = user;
        this.receipt = receipt;
        this.region = region;
        this.content = content;
        this.photos = photos;
        this.createdAt = new Date().getTime() / 1000L;
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
