package com.soptionssix.domain.service;

import com.soptionssix.api.dto.ReviewDto;
import com.soptionssix.api.param.ReviewParam;
import java.util.List;

public interface ReviewService {

    List<ReviewDto> getAllReview();

    ReviewDto saveReview(String userId, ReviewParam reviewParam);
}
