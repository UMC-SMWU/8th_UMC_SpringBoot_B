package umc.nnmrm.converter;

import umc.nnmrm.domain.Member;
import umc.nnmrm.domain.Review;
import umc.nnmrm.domain.Store;
import umc.nnmrm.web.dto.Review.ReviewRequestDTO;
import umc.nnmrm.web.dto.Review.ReviewResponseDTO;

public class ReviewConverter {

    public static Review toEntity(ReviewRequestDTO dto, Member member, Store store) {
        return Review.builder()
                .score(dto.getScore())
                .body(dto.getBody())
                .member(member)
                .store(store)
                .build();
    }

    public static ReviewResponseDTO fromEntity(Review review) {
        return ReviewResponseDTO.builder()
                .reviewId(review.getId())
                .createdAt(review.getCreatedAt())
                .build();
    }
}