package com.soptionssix.data.document;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "mock")
@Getter
@Setter
public final class MockDocument {

    @Id
    private ObjectId id;
    private String type;
    private String value;
}
