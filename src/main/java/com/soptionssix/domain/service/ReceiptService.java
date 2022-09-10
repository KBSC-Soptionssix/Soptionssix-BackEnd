package com.soptionssix.domain.service;

import com.soptionssix.api.dto.ReceiptDto;
import com.soptionssix.api.param.ReceiptParam;
import java.util.List;

public interface ReceiptService {

    List<ReceiptDto> getAllReceiptOf(String userId);

    ReceiptDto getReceiptById(String id);

    ReceiptDto saveReceipt(String userId, ReceiptParam receiptParam);
}
