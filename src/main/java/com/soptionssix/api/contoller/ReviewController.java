package com.soptionssix.api.contoller;

import com.soptionssix.api.dto.ReviewDto;
import com.soptionssix.api.utils.jwt.RequiredJwtToken;
import com.soptionssix.domain.service.ReviewService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("review")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("")
    public ResponseEntity<List<ReviewDto>> getAllReview() {
        List<ReviewDto> reviewDtos = this.reviewService.getAllReview();
        return ResponseEntity.ok(reviewDtos);
    }
}
