package com.soptionssix.api.contoller;

import com.soptionssix.api.dto.ProductDto;
import com.soptionssix.domain.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public ResponseEntity<List<ProductDto>> getProducts(
        @RequestParam(value = "filter", required = false) final String filter
    ) {
        List<ProductDto> productDtoList = productService.getProducts(filter);

        return ResponseEntity.ok(productDtoList);


    }


}
