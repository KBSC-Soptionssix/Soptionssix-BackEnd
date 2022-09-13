package com.soptionssix.data.serviceimpl;

import com.soptionssix.api.dto.ReviewDto;
import com.soptionssix.data.document.Review;
import com.soptionssix.data.repository.ReviewRepository;
import com.soptionssix.domain.service.ReviewService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class RemoteReviewService implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired
    public RemoteReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
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
}
