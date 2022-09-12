package com.soptionssix.domain.service;

import com.soptionssix.api.dto.ReceiptDto;

import java.util.List;

public interface ReceiptService {

    List<ReceiptDto> getAllReceiptOf(String userId);
}
