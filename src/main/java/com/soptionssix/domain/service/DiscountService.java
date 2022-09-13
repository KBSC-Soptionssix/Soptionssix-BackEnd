package com.soptionssix.domain.service;

import com.soptionssix.api.dto.DiscountDto;
import com.soptionssix.api.dto.DiscountStoreDetailDto;
import com.soptionssix.data.document.Product;
import com.soptionssix.data.document.Store;
import java.util.List;

public interface DiscountService {

    DiscountDto getDiscount();

    List<Store> getStores(int pageSize);


    List<Product> getProducts(int pageSize);

    List<Product> getDonationWaitProducts(int pageSize);

    DiscountStoreDetailDto getStoreDetail(String storeId);
}
