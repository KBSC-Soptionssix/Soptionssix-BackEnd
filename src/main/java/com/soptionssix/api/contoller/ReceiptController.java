package com.soptionssix.api.contoller;

import com.soptionssix.api.dto.ReceiptDto;
import com.soptionssix.domain.service.ReceiptService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("receipt")
public class ReceiptController {

    private final ReceiptService receiptService;

    @Autowired
    public ReceiptController(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    @GetMapping("")
    public ResponseEntity<List<ReceiptDto>> getAllReceipt() {
        List<ReceiptDto> receiptDtoList = receiptService.getAllReceipt("");
        return ResponseEntity.ok(receiptDtoList);
    }
}
