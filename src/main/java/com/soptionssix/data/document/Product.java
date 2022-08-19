package com.soptionssix.data.document;

@Entity
@Getter @Setter
public class Product {
    @Id @GenerateValue
    @Column(name = "product_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="store_id")
    private Store store;

    private String photo;
    private String name;
    private int stockCount;
    private int price;
    private int discount;
    private int donationCompleteCount;
    private int donationWaitCount;

}
