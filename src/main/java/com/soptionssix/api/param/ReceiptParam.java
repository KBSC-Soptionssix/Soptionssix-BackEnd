package com.soptionssix.api.param;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public record ReceiptParam(
    @Pattern(regexp = "\\d{11}", message = "Invalid User phone number")
    @NotNull(message = "user phone number is null")
    String phone,
    @NotNull(message = "storeId is null")
    String storeId,
    @NotNull(message = "productId is null")
    String productId,
    @Min(value = 1, message = "productCount less than 1")
    @NotNull(message = "productCount is null")
    int productCount,
    @NotNull(message = "pickUpTime is null")
    long pickUpTime,
    @NotNull(message = "paymentMethod is null")
    String paymentMethod,
    boolean isChallenge,
    boolean isDonate
) {

    public ReceiptParam(
        String phone,
        String storeId,
        String productId,
        int productCount,
        long pickUpTime,
        String paymentMethod,
        Boolean isChallenge,
        Boolean isDonate
    ) {
        this(
            phone,
            storeId,
            productId,
            productCount,
            pickUpTime,
            paymentMethod,
            isChallenge != null && isChallenge,
            isDonate != null && isDonate
        );
    }
}
