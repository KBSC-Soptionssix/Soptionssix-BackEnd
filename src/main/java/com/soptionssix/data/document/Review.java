package com.soptionssix.data.document;


import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Review {
    @Id @GenerateValue
    @Column(name = "review_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @OneToOne
    @JoinColumn(name="receipt_id")
    private Receipt receipt;

    private String region;
    private String content;

    private List<String> photos = new ArrayList<>();
    private Long createdAt;
}
