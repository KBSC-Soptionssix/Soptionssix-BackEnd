package com.soptionssix.data.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reference")
@Getter
@Setter
public final class ReferenceDocument {

    @Id
    private String id;
    private String title;
    private String mock;
}
