package com.soptionssix.api.dto;

import com.soptionssix.data.document.Store;
import javax.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class StorePreviewDto {

    @NotNull
    private final String id;
    private final String photo;
    @NotNull
    private final String name;
    private final String category;
    private final String description;
    @NotNull
    private final int maxDiscount;
    private final int discountStartTime;
    @NotNull
    private final String phone;
    private final int breakStartTime;
    private final int breakEndTime;
    @NotNull
    private final int startTime;
    @NotNull
    private final int endTime;
    @NotNull
    private final boolean hasChallenge;

    private StorePreviewDto(
        Store store
    ) {
        this.id = store.getId();
        this.photo = store.getPhoto();
        this.name = store.getName();
        this.category = store.getCategory();
        this.description = store.getDescription();
        this.maxDiscount = store.getMaxDiscount();
        this.discountStartTime = store.getDiscountStartTime();
        this.phone = store.getPhone();
        this.breakStartTime = store.getBreakStartTime();
        this.breakEndTime = store.getBreakEndTime();
        this.startTime = store.getStartTime();
        this.endTime = store.getEndTime();
        this.hasChallenge = store.isHasChallenge();
    }

    public static StorePreviewDto of(Store store) {
        return new StorePreviewDto(store);
    }
}
