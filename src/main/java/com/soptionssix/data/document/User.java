package com.soptionssix.data.document;


import lombok.Getter;
import lombok.Setter;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "user")
@Getter
@Setter
public class User {

    @Id
    private String id;

    private String nickName;

    private String phone;
}
