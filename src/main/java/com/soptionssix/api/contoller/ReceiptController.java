package com.soptionssix.api.contoller;

import com.soptionssix.api.dto.ReceiptDto;
import com.soptionssix.api.utils.jwt.JwtTokenProvider;
import com.soptionssix.api.utils.jwt.PayLoad;
import com.soptionssix.api.utils.jwt.RequiredJwtToken;
import com.soptionssix.domain.service.ReceiptService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("receipt")
public class ReceiptController {

    private final ReceiptService receiptService;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public ReceiptController(ReceiptService receiptService, JwtTokenProvider jwtTokenProvider) {
        this.receiptService = receiptService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @GetMapping("")
    @RequiredJwtToken
    public ResponseEntity<List<ReceiptDto>> getAllReceipt(
        @RequestHeader(value = "token") final String token
    ) {
        PayLoad payLoad = this.jwtTokenProvider.decodeJwtPayload(token);
        List<ReceiptDto> receiptDtoList = receiptService.getAllReceiptOf(payLoad.userId());
        return ResponseEntity.ok(receiptDtoList);
    }
}
