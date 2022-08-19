package com.soptionssix.data.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "reference")
@Getter
@Setter
public final class ReferenceDocument {

    @Id
    private String id;
    private String title;
    @DocumentReference()
    private MockDocument mock;

    public ReferenceDocument(String title, MockDocument mock) {
        this.title = title;
        this.mock = mock;
    }
}
