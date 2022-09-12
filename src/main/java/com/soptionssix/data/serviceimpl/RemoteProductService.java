package com.soptionssix.data.serviceimpl;

import com.soptionssix.api.dto.ProductDto;
import com.soptionssix.data.document.Product;
import com.soptionssix.data.repository.ProductRepository;
import com.soptionssix.domain.service.ProductService;

import java.util.List;

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
    public List<ProductDto> getAllProduct() {
        List<Product> products = productRepository.findAll();
        return products.stream()
            .map((value) -> ProductDto.of(value))
            .toList();
    }
}
