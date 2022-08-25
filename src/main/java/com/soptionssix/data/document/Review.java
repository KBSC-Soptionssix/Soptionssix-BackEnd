package com.soptionssix.data.document;


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

    @DocumentReference(db = "user")
    private User user;

    @DocumentReference(db = "receipt")
    private Receipt receipt;

    private String region;
    private String content;

    private List<String> photos;
    private Long createdAt;

    protected Review() {
    }
}
