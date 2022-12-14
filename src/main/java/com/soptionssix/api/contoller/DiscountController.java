package com.soptionssix.api.contoller;


import com.soptionssix.api.dto.DiscountDto;
import com.soptionssix.api.dto.DiscountStoreDetailDto;
import com.soptionssix.domain.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("discount")
public class DiscountController {

    private final DiscountService discountService;

    @Autowired
    public DiscountController(DiscountService discountService) {
        this.discountService = discountService;
    }

    @GetMapping("")
    public ResponseEntity<DiscountDto> getDiscount() {
        DiscountDto discountDto = discountService.getDiscount();
        return ResponseEntity.ok(discountDto);
    }

    @GetMapping("{storeId}")
    public ResponseEntity<DiscountStoreDetailDto> getStoreDetail(
        @PathVariable(value = "storeId") final String storeId
    ) {
        DiscountStoreDetailDto discountStoreDetailDto = discountService.getStoreDetail(storeId);
        return ResponseEntity.ok(discountStoreDetailDto);
    }
}
