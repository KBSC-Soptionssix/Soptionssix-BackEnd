package com.soptionssix.data.serviceimpl;

import com.soptionssix.api.dto.ProductDto;
import com.soptionssix.api.dto.StoreDetailDto;
import com.soptionssix.api.dto.StoreDto;
import com.soptionssix.data.document.Product;
import com.soptionssix.data.document.Store;
import com.soptionssix.data.repository.ProductRepository;
import com.soptionssix.data.repository.StoreRepository;
import com.soptionssix.domain.error.SoptionsException;
import com.soptionssix.domain.service.StoreService;
import java.util.List;
import java.util.Optional;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoteStoreService implements StoreService {

    private final StoreRepository storeRepository;
    private final ProductRepository productRepository;

    @Autowired
    public RemoteStoreService(
        StoreRepository storeRepository, ProductRepository productRepository
    ) {
        this.storeRepository = storeRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<StoreDto> getAllStore() {

        List<Store> stores = storeRepository.findAll();
        return stores.stream()
            .map((value) -> StoreDto.of(value))
            .toList();
    }

    @Override
    public StoreDetailDto getStoreDetail(String id) {
        Product product = productRepository.findById(id).orElseThrow(
            () -> {
                throw new SoptionsException.BadRequest("product id가 잘못되었습니다");
            }
        );
        ProductDto productDto = ProductDto.of(product);
        Store store = product.getStore();

        return StoreDetailDto.of(store, productDto);
    }

}
