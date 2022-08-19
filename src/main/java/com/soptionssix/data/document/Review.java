package com.soptionssix.data.document;


import lombok.Getter;
import lombok.Setter;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(value="review")
@Getter
@Setter
public class Review {
    @Id
    private String id;

    private String user;

    private String receipt;

    private String region;
    private String content;

    private List<String> photos = new ArrayList<>();
    private Long createdAt;
}
