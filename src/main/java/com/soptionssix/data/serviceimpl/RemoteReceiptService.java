package com.soptionssix.data.serviceimpl;

import com.soptionssix.api.dto.ReceiptDto;
import com.soptionssix.data.document.Receipt;
import com.soptionssix.data.repository.ReceiptRepository;
import com.soptionssix.domain.service.ReceiptService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoteReceiptService implements ReceiptService {

    private final ReceiptRepository receiptRepository;

    @Autowired
    public RemoteReceiptService(ReceiptRepository receiptRepository) {
        this.receiptRepository = receiptRepository;
    }

    @Override
    public List<ReceiptDto> getAllReceipt(String userId) {
        List<Receipt> receipts = receiptRepository.findAll();
        return receipts.stream()
            .map(ReceiptDto::of)
            .toList();
    }
}
