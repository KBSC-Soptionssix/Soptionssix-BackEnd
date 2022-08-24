package com.soptionssix.api.dto;

import javax.validation.constraints.NotNull;
import nonapi.io.github.classgraph.json.Id;

public record StoreDetailDto(
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
    String loadAddress,
    @NotNull
    String address,
    @NotNull
    String mapX,
    @NotNull
    String mapY,
    @NotNull
    boolean hasChallenge
    // TODO: product list 필요.
) {

}
