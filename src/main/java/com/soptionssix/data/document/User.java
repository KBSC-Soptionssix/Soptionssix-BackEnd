package com.soptionssix.data.document;


import lombok.Getter;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "user")
@Getter
public class User {

    @Id
    private String id;

    private String nickName;
    private String phone;

    protected User() {
    }
}
