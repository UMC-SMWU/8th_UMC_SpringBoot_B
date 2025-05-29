package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Review;
import umc.spring.dto.Review.ReviewResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ReviewConverter {

    public static ReviewResponseDTO.MyReviewDTO toMyReviewDTO(Review review) {
        return ReviewResponseDTO.MyReviewDTO.builder()
                .body(review.getBody())
                .score(review.getScore())
                .storeName(review.getStore().getName())
                .createdAt(review.getCreatedAt().toLocalDate())
                .build();
    }

    public static ReviewResponseDTO.MyReviewListDTO toMyReviewListDTO(Page<Review> reviewPage) {
        List<ReviewResponseDTO.MyReviewDTO> reviewDTOs = reviewPage.stream()
                .map(ReviewConverter::toMyReviewDTO)
                .collect(Collectors.toList());

        return ReviewResponseDTO.MyReviewListDTO.builder()
                .isFirst(reviewPage.isFirst())
                .isLast(reviewPage.isLast())
                .totalPage(reviewPage.getTotalPages())
                .totalElements(reviewPage.getTotalElements())
                .listSize(reviewDTOs.size())
                .reviewList(reviewDTOs)
                .build();
    }
}

