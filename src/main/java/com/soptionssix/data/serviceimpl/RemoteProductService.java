package com.soptionssix.data.serviceimpl;

import com.soptionssix.api.dto.ProductDto;
import com.soptionssix.data.document.Product;
import com.soptionssix.data.repository.ProductRepository;
import com.soptionssix.domain.error.SoptionsException;
import com.soptionssix.domain.error.SoptionsException.BadRequest;
import com.soptionssix.domain.service.ProductService;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoteProductService implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public RemoteProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDto> getProducts(String filter) {
        List<Product> products;
        if (Objects.equals(filter, "donation")) {
            products = productRepository.findByDonationWaitCountGreaterThan(0);

        } else if (Objects.equals(filter, null)) {
            products = productRepository.findAll();
        } else {
            throw new SoptionsException.BadRequest("잘못된 요청입니다");
        }
        return products.stream()
            .map((value) -> ProductDto.of(value))
            .toList();
    }

}
