package com.soptionssix.data.document;


import lombok.Getter;
import lombok.Setter;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "store")
@Getter
public class Store {

    @Id
    private String id;

    private String photo;
    private String name;
    private String category;
    private String description;
    private int maxDiscount;
    private int discountStartTime;
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

    public Store(
        String photo,
        String name,
        String category,
        String description,
        int maxDiscount,
        int discountStartTime,
        String phone,
        int breakStartTime,
        int breakEndTime,
        int startTime,
        int endTime,
        String loadAddress,
        String address,
        String mapX,
        String mapY,
        boolean hasChallenge
    ) {
        this.photo = photo;
        this.name = name;
        this.category = category;
        this.description = description;
        this.maxDiscount = maxDiscount;
        this.discountStartTime = discountStartTime;
        this.phone = phone;
        this.breakStartTime = breakStartTime;
        this.breakEndTime = breakEndTime;
        this.startTime = startTime;
        this.endTime = endTime;
        this.loadAddress = loadAddress;
        this.address = address;
        this.mapX = mapX;
        this.mapY = mapY;
        this.hasChallenge = hasChallenge;
    }
}
