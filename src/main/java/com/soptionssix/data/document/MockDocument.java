package com.soptionssix.data.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "mock")
@Getter
@Setter
public final class MockDocument {

    @Id
    private String id;
    private String type;
    private String value;

    public MockDocument(String type, String value) {
        this.type = type;
        this.value = value;
    }
}
