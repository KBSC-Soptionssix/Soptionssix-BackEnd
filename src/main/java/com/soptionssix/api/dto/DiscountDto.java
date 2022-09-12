package com.soptionssix.api.dto;

import com.soptionssix.data.document.Product;
import com.soptionssix.data.document.Store;

import java.util.List;
import javax.validation.constraints.NotNull;

import lombok.Getter;

@Getter
public class DiscountDto {

    @NotNull
    private final List<StoreDto> storeList;

    @NotNull
    private final List<ProductDto> productList;
    @NotNull
    private final List<ProductDto> waitDonationList;

    private DiscountDto(
        List<StoreDto> storeList, List<ProductDto> productList, List<ProductDto> waitDonationList
    ) {
        this.storeList = storeList;
        this.productList = productList;
        this.waitDonationList = waitDonationList;
    }

    public static DiscountDto of(
        List<Store> storeList, List<Product> productList, List<Product> waitDonationList
    ) {
        return new DiscountDto(
            mappingToStoreDtoOf(storeList),
            mappingToProductDtoOf(productList),
            mappingToProductDtoOf(waitDonationList)
        );
    }

    private static List<StoreDto> mappingToStoreDtoOf(List<Store> storeList) {
        return storeList.stream()
            .map(StoreDto::of)
            .toList();
    }

    private static List<ProductDto> mappingToProductDtoOf(List<Product> productList) {
        return productList.stream()
            .map(ProductDto::of)
            .toList();
    }
}
