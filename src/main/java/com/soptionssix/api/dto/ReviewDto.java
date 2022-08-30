package com.soptionssix.api.dto;

import com.soptionssix.data.document.Review;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class ReviewDto {

    @NotNull
    private final String id;

    @NotNull
    private final UserDto user;

    @NotNull
    private final ReceiptPreviewDto receiptPreview;
    @NotNull
    private final String region;
    @NotNull
    private final String content;

    private final List<String> photos;
    @NotNull
    private final Long createdAt;

    private ReviewDto(
        Review review
    ) {
        this.id = review.getId();
        this.user = UserDto.of(review.getUser());
        this.receiptPreview = ReceiptPreviewDto.of(review.getReceipt());
        this.region = review.getRegion();
        this.content = review.getContent();
        this.photos = review.getPhotos();
        this.createdAt = review.getCreatedAt();
    }

    public static ReviewDto of(Review review) {
        return new ReviewDto(review);
    }
}
