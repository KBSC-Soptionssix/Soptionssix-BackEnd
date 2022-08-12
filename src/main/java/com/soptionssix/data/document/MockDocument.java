package com.soptionssix.data.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document("mock")
@Getter
@Setter
public final class MockDocument {
    @MongoId
    private String _id;
    private String type;
    private String value;
}
