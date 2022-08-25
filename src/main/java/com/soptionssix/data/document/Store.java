package com.soptionssix.data.document;


import javax.validation.constraints.NotNull;
import lombok.Getter;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "store")
@Getter
public class Store {

    @Id
    private String id;

    private String photo;
    @NotNull
    private String name;
    private String category;
    private String description;

    @NotNull
    private int maxDiscount;
    private int discountStartTime;
    @NotNull
    private String phone;
    private int breakStartTime;
    private int breakEndTime;
    @NotNull
    private int startTime;
    @NotNull
    private int endTime;
    @NotNull
    private String loadAddress;
    @NotNull
    private String address;
    @NotNull
    private String mapX;
    @NotNull
    private String mapY;
    @NotNull
    private boolean hasChallenge;

    protected Store() {
    }


}
