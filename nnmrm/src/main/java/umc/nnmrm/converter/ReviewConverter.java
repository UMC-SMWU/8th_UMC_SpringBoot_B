package umc.nnmrm.converter;

import org.springframework.data.domain.Page;
import umc.nnmrm.domain.Member;
import umc.nnmrm.domain.Review;
import umc.nnmrm.domain.Store;
import umc.nnmrm.web.dto.Review.ReviewCreateRequestDTO;
import umc.nnmrm.web.dto.Review.ReviewCreateResponseDTO;
import umc.nnmrm.web.dto.Review.ReviewResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ReviewConverter {

    public static Review toEntity(ReviewCreateRequestDTO dto, Member member, Store store) {
        return Review.builder()
                .score(dto.getScore())
                .body(dto.getBody())
                .member(member)
                .store(store)
                .build();
    }

    public static ReviewCreateResponseDTO fromEntity(Review review) {
        return ReviewCreateResponseDTO.builder()
                .reviewId(review.getId())
                .createdAt(review.getCreatedAt())
                .build();
    }

    public static ReviewResponseDTO.MyReviewDTO toMyReviewDTO(Review review) {
        return ReviewResponseDTO.MyReviewDTO.builder()
                .reviewId(review.getId())
                .storeName(review.getStore().getName())
                .score(review.getScore())
                .body(review.getBody())
                .createdAt(review.getCreatedAt().toLocalDate())
                .build();
    }

    public static ReviewResponseDTO.MyReviewListDTO toMyReviewListDTO(Page<Review> reviewPage) {
        List<ReviewResponseDTO.MyReviewDTO> dtoList = reviewPage.stream()
                .map(ReviewConverter::toMyReviewDTO)
                .collect(Collectors.toList());

        return ReviewResponseDTO.MyReviewListDTO.builder()
                .reviews(dtoList)
                .listSize(dtoList.size())
                .totalPage(reviewPage.getTotalPages())
                .totalElements(reviewPage.getTotalElements())
                .isFirst(reviewPage.isFirst())
                .isLast(reviewPage.isLast())
                .build();
    }
}