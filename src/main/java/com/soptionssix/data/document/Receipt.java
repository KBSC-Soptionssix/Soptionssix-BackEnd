package com.soptionssix.data.document;

@Entity
@Getter @Setter
public class Receipt {
    @Id @GenerateValue
    @Column(name = "receipt_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="store_id")
    private Store store;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    @OneToOne
    @JoinColumn(name="review_id")
    private Review review;

    private int productCount;
    private Long date;
    private Long pickUpTime;
    private String paymentMethod;
    private boolean isChallenge;
    private boolean isDonate;

}
