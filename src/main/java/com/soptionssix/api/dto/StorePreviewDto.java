package com.soptionssix.api.dto;

import javax.validation.constraints.NotNull;
import nonapi.io.github.classgraph.json.Id;

public record StorePreviewDto(
    @Id
    String id,
    String photo,
    @NotNull
    String name,
    String category,
    String description,
    @NotNull
    int maxDiscount,
    int discountStartTime,
    @NotNull
    String phone,
    int breakStartTime,
    int breakEndTime,
    @NotNull
    int startTime,
    @NotNull
    int endTime,
    @NotNull
    boolean hasChallenge
) {

}
