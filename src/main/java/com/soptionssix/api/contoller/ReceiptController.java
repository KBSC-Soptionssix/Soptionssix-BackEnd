package com.soptionssix.api.contoller;

import com.soptionssix.api.dto.ReceiptDto;
import com.soptionssix.api.param.ReceiptParam;
import com.soptionssix.api.utils.jwt.JwtTokenProvider;
import com.soptionssix.api.utils.jwt.PayLoad;
import com.soptionssix.api.utils.jwt.RequiredJwtToken;
import com.soptionssix.domain.error.SoptionsException;
import com.soptionssix.domain.error.SoptionsException.BadRequest;
import com.soptionssix.domain.service.ProductService;
import com.soptionssix.domain.service.ReceiptService;
import com.soptionssix.domain.service.UserService;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("receipt")
public class ReceiptController {

    private final ReceiptService receiptService;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public ReceiptController(
        ReceiptService receiptService,
        JwtTokenProvider jwtTokenProvider
    ) {
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

    @GetMapping("{id}")
    @RequiredJwtToken
    public ResponseEntity<ReceiptDto> getReceiptById(
        @PathVariable("id") String id
    ) {
        ReceiptDto receiptDto = this.receiptService.getReceiptById(id);
        return ResponseEntity.ok(receiptDto);
    }

    @PostMapping("")
    @RequiredJwtToken
    public ResponseEntity<ReceiptDto> addReceipt(
        @RequestHeader(value = "token") final String token,
        @RequestBody @Valid ReceiptParam receiptParam
    ) {
        PayLoad payLoad = this.jwtTokenProvider.decodeJwtPayload(token);
        ReceiptDto receiptDto = receiptService.saveReceipt(
            payLoad.userId(), receiptParam
        );
        return ResponseEntity.ok(receiptDto);
    }
}
