package com.soptionssix.data.serviceimpl;

import com.soptionssix.api.dto.StoreDetailDto;
import com.soptionssix.api.dto.StoreDto;
import com.soptionssix.data.document.Product;
import com.soptionssix.data.document.Store;
import com.soptionssix.data.repository.StoreRepository;
import com.soptionssix.domain.service.StoreService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoteStoreService implements StoreService {

    private final StoreRepository storeRepository;

    @Autowired
    public RemoteStoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
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

    }

}
