package umc.spring.converter;

import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.web.dto.Request.MemberRequestDTO;
import umc.spring.web.dto.Response.MemberResponseDTO;

import java.time.LocalDateTime;

public class ReviewConverter {
    public static MemberResponseDTO.CreateReviewResponseDTO toCreateReivewResponseDTO(Review review){
        return MemberResponseDTO.CreateReviewResponseDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(MemberRequestDTO.ReviewDto request, Store store) {
        return Review.builder()
                .store(store)
                .body(request.getBody())
                .score(request.getScore())
                .build();
    }
}
