package com.soptionssix.data.document;


import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(value = "review")
@Getter
public class Review {

    @Id
    private String id;

    @DocumentReference(db = "user")
    private User user;

    @DocumentReference(db = "receipt")
    private Receipt receipt;

    private String region;
    private String content;

    private List<String> photos = new ArrayList<>();
    private Long createdAt;

    public Review(
        User user, Receipt receipt, String region, String content, List<String> photos
    ) {
        this.user = user;
        this.receipt = receipt;
        this.region = region;
        this.content = content;
        this.photos = photos;
        this.createdAt = System.currentTimeMillis() / 1000L;
    }

    public Review(User user, Receipt receipt, String region, String content) {
        this(user, receipt, region, content, null);
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }
}
