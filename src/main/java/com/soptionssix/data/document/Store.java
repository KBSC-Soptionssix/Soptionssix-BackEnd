package com.soptionssix.data.document;


import lombok.Getter;
import lombok.Setter;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value="store")
@Getter
@Setter
public class Store {
    @Id
    private String id;

    private String photo;
    private String name;
    private String category;
    private String description;
    private int maxDiscount;
    private String phone;
    private int breakStartTime;
    private int breakEndTime;
    private int startTime;
    private int endTime;
    private String loadAddress;
    private String address;
    private String mapX;
    private String mapY;
    private boolean hasChallenge;

}
