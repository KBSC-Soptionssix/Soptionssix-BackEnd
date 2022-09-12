package com.soptionssix.domain.service;

import com.soptionssix.api.dto.StoreDetailDto;
import com.soptionssix.api.dto.StoreDto;
import java.util.List;


public interface StoreService {

    List<StoreDto> getAllStore();

    StoreDetailDto getStoreDetail(String id);
}
