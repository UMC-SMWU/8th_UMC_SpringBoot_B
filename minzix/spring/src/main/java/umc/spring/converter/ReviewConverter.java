package umc.spring.converter;

import umc.spring.domain.Review;
import umc.spring.dto.Review.ReviewResponseDTO;

public class ReviewConverter {

    public static ReviewResponseDTO.MyReviewDTO toMyReviewDTO(Review review) {
        return ReviewResponseDTO.MyReviewDTO.builder()
                .body(review.getBody())
                .score(review.getScore())
                .storeName(review.getStore().getName())
                .createdAt(review.getCreatedAt().toLocalDate())
                .build();
    }
}

