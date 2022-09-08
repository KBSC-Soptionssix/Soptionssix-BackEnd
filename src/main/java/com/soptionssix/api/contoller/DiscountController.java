package com.soptionssix.api.contoller;


import com.soptionssix.api.dto.DiscountDto;
import com.soptionssix.api.dto.ProductDto;
import com.soptionssix.domain.service.DiscountService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
}
