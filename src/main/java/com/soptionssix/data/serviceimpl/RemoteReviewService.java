package com.soptionssix.data.serviceimpl;

import com.soptionssix.api.dto.ReviewDto;
import com.soptionssix.api.param.ReviewParam;
import com.soptionssix.data.document.Receipt;
import com.soptionssix.data.document.Review;
import com.soptionssix.data.document.User;
import com.soptionssix.data.repository.ReceiptRepository;
import com.soptionssix.data.repository.ReviewRepository;
import com.soptionssix.data.repository.UserRepository;
import com.soptionssix.domain.error.SoptionsException.BadRequest;
import com.soptionssix.domain.error.SoptionsException.Unauthenticated;
import com.soptionssix.domain.service.ReviewService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class RemoteReviewService implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final ReceiptRepository receiptRepository;

    @Autowired

    public RemoteReviewService(
        ReviewRepository reviewRepository, UserRepository userRepository,
        ReceiptRepository receiptRepository
    ) {
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
        this.receiptRepository = receiptRepository;
    }

    @Override
    public List<ReviewDto> getAllReview() {
        // TODO : Service 에 있을 로직은 아닌 것 같음 추후에 Repository 안으로 옮겨보자 :(
        Sort sort = Sort.by(Direction.DESC, "createdAt");
        List<Review> reviews = this.reviewRepository.findAll(sort);
        return reviews.stream()
            .map(ReviewDto::of)
            .toList();
    }

    @Override
    public ReviewDto getReview(String reviewId) {
        Review review = reviewRepository.findById(reviewId)
            .orElseThrow(
                () -> {
                    throw new BadRequest("can not find reviewId");
                }
            );
        return ReviewDto.of(review);
    }

    @Override
    public ReviewDto saveReview(String userId, ReviewParam reviewParam) {
        User user = findUserDataById(userId);
        Receipt receipt = findReceiptDataById(reviewParam.receipt());
        Review review = reviewRepository.save(
            Review.of(user, receipt, reviewParam)
        );
        updateReceipt(receipt, review);
        return ReviewDto.of(review);
    }

    private User findUserDataById(String userId) {
        return userRepository.findById(userId)
            .orElseThrow(
                () -> {
                    throw new Unauthenticated("Unauthenticated user");
                }
            );
    }

    private Receipt findReceiptDataById(String receiptId) {
        return receiptRepository.findById(receiptId)
            .orElseThrow(
                () -> {
                    throw new BadRequest("can not find receiptId");
                }
            );
    }

    private void updateReceipt(Receipt receipt, Review review) {
        receipt.addReview(review);
        receiptRepository.save(receipt);
    }
}
