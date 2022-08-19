package com.soptionssix.data.document;

import lombok.Getter;
import lombok.Setter;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value="receipt")
@Getter
@Setter
public class Receipt {
    @Id
    private String id;


    private String user;

    private String store;

    private String product;

    private String review;

    private int productCount;
    private Long date;
    private Long pickUpTime;
    private String paymentMethod;
    private boolean isChallenge;
    private boolean isDonate;

}
