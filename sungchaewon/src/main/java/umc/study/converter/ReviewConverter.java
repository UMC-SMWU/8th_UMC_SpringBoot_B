package umc.study.converter;

import org.springframework.data.domain.Page;
import umc.study.domain.Review;
import umc.study.domain.Member;
import umc.study.domain.ReviewImage;
import umc.study.domain.Store;
import umc.study.web.dto.ReviewMyPageListDTO;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewMyPageDTO;


import java.util.ArrayList;
import java.util.stream.Collectors;

public class ReviewConverter {

    public static Review toReview(ReviewRequestDTO dto, Member member, Store store) {
        return Review.builder()
                .member(member)
                .store(store)
                .score(dto.getRating().floatValue())
                .title("리뷰") // 기본 타이틀 지정
                .body(dto.getContent())
                .build();
    }

    public static ReviewMyPageDTO toReviewMyPageDTO(Review review) {
        return ReviewMyPageDTO.builder()
                .storeName(review.getStore().getName())
                .score(review.getScore())
                .body(review.getBody())
                .createdAt(review.getCreatedAt().toLocalDate())
                .imageUrls(
                        review.getReviewImageList() != null ?
                                review.getReviewImageList().stream()
                                        .map(ReviewImage::getImageUrl)
                                        .collect(Collectors.toList()) :
                                new ArrayList<>()
                )
                .ownerComment(
                        review.getOwnerComment() != null ?
                                review.getOwnerComment() :
                                ""
                )
                .build();
    }

    public static ReviewMyPageListDTO toMyPageListDTO(Page<Review> reviewPage) {
        return ReviewMyPageListDTO.builder()
                .reviewList(reviewPage.stream()
                        .map(ReviewConverter::toReviewMyPageDTO)
                        .collect(Collectors.toList()))
                .totalPage(reviewPage.getTotalPages())
                .totalElements(reviewPage.getTotalElements())
                .build();
    }
}
