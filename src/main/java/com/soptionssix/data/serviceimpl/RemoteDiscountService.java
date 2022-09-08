package com.soptionssix.data.serviceimpl;

import com.soptionssix.api.dto.DiscountDto;
import com.soptionssix.api.dto.ProductDto;
import com.soptionssix.api.dto.StoreDetailDto;
import com.soptionssix.data.document.Product;
import com.soptionssix.data.document.Store;
import com.soptionssix.data.repository.ProductRepository;
import com.soptionssix.data.repository.StoreRepository;
import com.soptionssix.domain.service.DiscountService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class RemoteDiscountService implements DiscountService {

    private final StoreRepository storeRepository;
    private final ProductRepository productRepository;


    @Autowired
    public RemoteDiscountService(
        StoreRepository storeRepository, ProductRepository productRepository
    ) {
        this.storeRepository = storeRepository;
        this.productRepository = productRepository;
    }

    @Override
    public DiscountDto getDiscount() {

        Page<Store> storePage = storeRepository.findAll(PageRequest.of(0, 5));
        List<Store> storeList = storePage.getContent();

        Page<Product> productPage = productRepository.findAll(PageRequest.of(0, 5));
        List<Product> productList = productPage.getContent();

        List<Product> waitDonations = productRepository.findByDonationWaitCountGreaterThan(0);
        List<Product> waitDonationList = waitDonations.stream().limit(5).toList();

        return DiscountDto.of(storeList, productList, waitDonationList);
    }
}
