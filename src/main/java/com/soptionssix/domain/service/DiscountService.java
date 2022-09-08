package com.soptionssix.domain.service;

import com.soptionssix.api.dto.DiscountDto;
import com.soptionssix.api.dto.DiscountStoreDetailDto;

public interface DiscountService {

    DiscountDto getDiscount();

    DiscountStoreDetailDto getStoreDetail(String storeId);
}
