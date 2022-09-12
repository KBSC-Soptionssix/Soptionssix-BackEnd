package com.soptionssix.data.serviceimpl;

import com.soptionssix.api.dto.DiscountDto;
import com.soptionssix.api.dto.DiscountStoreDetailDto;
import com.soptionssix.api.dto.ProductDto;
import com.soptionssix.data.document.Product;
import com.soptionssix.data.document.Store;
import com.soptionssix.data.repository.ProductRepository;
import com.soptionssix.data.repository.StoreRepository;
import com.soptionssix.domain.error.SoptionsException;
import com.soptionssix.domain.service.DiscountService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

        List<Store> storeList = getStores(5);

        List<Product> productList = getProducts(5);

        List<Product> waitDonationList = getDonationWaitProducts((5));
        return DiscountDto.of(storeList, productList, waitDonationList);
    }

    @Override
    public List<Store> getStores(int pageSize) {
        Page<Store> storePage = storeRepository.findAll(PageRequest.of(0, pageSize));
        List<Store> storeList = storePage.getContent();
        return storeList;
    }

    @Override
    public List<Product> getProducts(int pageSize) {
        Page<Product> productPage = productRepository.findAll(PageRequest.of(0, pageSize));
        List<Product> productList = productPage.getContent();
        return productList;
    }

    @Override
    public List<Product> getDonationWaitProducts(int pageSize) {
        List<Product> waitDonations = productRepository.findByDonationWaitCountGreaterThan(0);
        List<Product> waitDonationList = waitDonations.stream().limit(pageSize).toList();
        return waitDonationList;
    }

    @Override
    public DiscountStoreDetailDto getStoreDetail(String storeId) {
        Store store = storeRepository.findById(storeId).orElseThrow(
            () -> {
                throw new SoptionsException.BadRequest("store id가 잘못되었습니다");
            }
        );

        List<Product> productList = productRepository.findByStore(store);

        List<ProductDto> products = productList.stream().map((value) -> ProductDto.of(value))
            .toList();

        return DiscountStoreDetailDto.of(store, products);
    }
}
