package com.soptionssix.api.dto;

import com.soptionssix.data.document.Receipt;
import javax.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class ReceiptPreviewDto {

    @NotNull
    private final String id;

    @NotNull
    private final String userId;

    @NotNull
    private final ProductDto product;
    @NotNull
    private final int productCount;
    @NotNull
    private final Long date;
    @NotNull
    private final Long pickUpTime;
    @NotNull
    private final String paymentMethod;
    @NotNull
    private final boolean isChallenge;
    @NotNull
    private final boolean isDonate;

    private ReceiptPreviewDto(
        Receipt receipt
    ) {
        this.id = receipt.getId();
        this.userId = UserDto.of(receipt.getUser()).getId();
        this.product = ProductDto.of(receipt.getProduct());
        this.productCount = receipt.getProductCount();
        this.date = receipt.getDate();
        this.pickUpTime = receipt.getPickUpTime();
        this.paymentMethod = receipt.getPaymentMethod();
        this.isChallenge = receipt.isChallenge();
        this.isDonate = receipt.isDonate();
    }

    public static ReceiptPreviewDto of(Receipt receipt) {
        return new ReceiptPreviewDto(receipt);
    }
}
