package com.soptionssix.data.document;


@Entity
@Getter @Setter
public class User {

    @Id @GenerateValue
    @Column(name = "user_id")
    private Long id;

    private String nickName;

    private String phone;
}
