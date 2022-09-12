package com.soptionssix.api.dto;

import com.soptionssix.data.document.Product;

import javax.validation.constraints.NotNull;

import lombok.Getter;

@Getter
public class ProductDto {

    @NotNull
    private final String id;
    @NotNull
    private final StorePreviewDto storePreview;
    private final String photo;
    @NotNull
    private final String name;
    @NotNull
    private final int stockCount;
    @NotNull
    private final int price;
    @NotNull
    private final int discount;
    private final int donationCompleteCount;
    private final int donationWaitCount;

    private ProductDto(
        Product product
    ) {
        this.id = product.getId();
        this.storePreview = StorePreviewDto.of(product.getStore());
        this.photo = product.getPhoto();
        this.name = product.getName();
        this.stockCount = product.getStockCount();
        this.price = product.getPrice();
        this.discount = product.getDiscount();
        this.donationCompleteCount = product.getDonationCompleteCount();
        this.donationWaitCount = product.getDonationWaitCount();
    }

    public static ProductDto of(Product product) {
        return new ProductDto(product);
    }
}
