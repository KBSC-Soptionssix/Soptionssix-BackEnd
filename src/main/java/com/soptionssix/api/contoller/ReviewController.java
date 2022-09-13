package com.soptionssix.api.contoller;

import com.soptionssix.api.dto.ReviewDto;
import com.soptionssix.api.param.ReviewParam;
import com.soptionssix.api.utils.jwt.JwtTokenProvider;
import com.soptionssix.api.utils.jwt.PayLoad;
import com.soptionssix.api.utils.jwt.RequiredJwtToken;
import com.soptionssix.domain.service.ReviewService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@Validated
@RequestMapping("review")
public class ReviewController {

    private final ReviewService reviewService;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public ReviewController(ReviewService reviewService, JwtTokenProvider jwtTokenProvider) {
        this.reviewService = reviewService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @GetMapping("")
    public ResponseEntity<List<ReviewDto>> getAllReview() {
        List<ReviewDto> reviewDtos = this.reviewService.getAllReview();
        return ResponseEntity.ok(reviewDtos);
    }

    @PostMapping("")
    @RequiredJwtToken
    public ResponseEntity<ReviewDto> addReview(
        @RequestHeader(value = "token") final String token,
        @RequestBody @Valid ReviewParam reviewParam
    ) {
        PayLoad payLoad = jwtTokenProvider.decodeJwtPayload(token);
        ReviewDto reviewDto = reviewService.saveReview(payLoad.userId(), reviewParam);
        return ResponseEntity.ok(reviewDto);
    }

    @GetMapping("{reviewId}")
    public ResponseEntity<ReviewDto> getReview(
        @PathVariable("reviewId") String reviewId
    ) {
        ReviewDto reviewDto = reviewService.getReview(reviewId);
        return ResponseEntity.ok(reviewDto);
    }
}
