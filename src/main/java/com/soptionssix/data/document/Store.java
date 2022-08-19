package com.soptionssix.data.document;


@Entity
@Getter @Setter
public class Store {
    @Id @GenerateValue
    @Column(name = "store_id")
    private Long id;

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
