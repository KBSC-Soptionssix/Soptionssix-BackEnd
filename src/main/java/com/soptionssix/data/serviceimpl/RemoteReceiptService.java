package com.soptionssix.data.serviceimpl;

import com.soptionssix.api.dto.ReceiptDto;
import com.soptionssix.api.param.ReceiptParam;
import com.soptionssix.data.document.Product;
import com.soptionssix.data.document.Receipt;
import com.soptionssix.data.document.User;
import com.soptionssix.data.repository.ProductRepository;
import com.soptionssix.data.repository.ReceiptRepository;
import com.soptionssix.data.repository.UserRepository;
import com.soptionssix.domain.error.SoptionsException;
import com.soptionssix.domain.error.SoptionsException.BadRequest;
import com.soptionssix.domain.error.SoptionsException.Unauthenticated;
import com.soptionssix.domain.service.ReceiptService;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoteReceiptService implements ReceiptService {

    private final ReceiptRepository receiptRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    /* TODO
     *   하.. 여기서 유저, 상품 레포지터리 의존성을 가지는게 맞는지 모르겠음;;
     *   지금으로는 이거 말고 구현하기엔 이것저것 너무 많이 건드리니 추후에 고칠 예정.. :(
     * */
    @Autowired
    public RemoteReceiptService(
        ReceiptRepository receiptRepository, UserRepository userRepository,
        ProductRepository productRepository
    ) {
        this.receiptRepository = receiptRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<ReceiptDto> getAllReceiptOf(String userId) {
        List<Receipt> receipts = receiptRepository.findByUser(new ObjectId(userId));
        return receipts.stream()
            .map(ReceiptDto::of)
            .toList();
    }

    @Override
    public ReceiptDto getReceiptById(String id) {
        Receipt receipt = this.receiptRepository.findById(id)
            .orElseThrow(
                () -> {
                    throw new SoptionsException.BadRequest("can not find receipt");
                }
            );
        return ReceiptDto.of(receipt);
    }

    @Override
    public ReceiptDto saveReceipt(String userId, ReceiptParam receiptParam) {
        User user = userRepository.findById(userId)
            .orElseThrow(
                () -> {
                    throw new Unauthenticated("unauthenticated user");
                }
            );
        Product product = productRepository.findById(receiptParam.productId())
            .orElseThrow(
                () -> {
                    throw new BadRequest("can not found productId");
                }
            );
        Receipt receipt = receiptRepository.save(
            Receipt.of(user, product.getStore(), product, receiptParam)
        );
        return ReceiptDto.of(receipt);
    }
}
