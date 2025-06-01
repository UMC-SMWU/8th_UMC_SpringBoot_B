package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.web.dto.Request.MemberRequestDTO;
import umc.spring.web.dto.Response.MemberResponseDTO;
import umc.spring.web.dto.Response.StoreResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    public static StoreResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review){
        return StoreResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();
    }
    public static StoreResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){

        List<StoreResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(ReviewConverter::reviewPreViewDTO).collect(Collectors.toList());

        return StoreResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }

    public static MemberResponseDTO.MyReviewPreViewDTO myReviewPreviewDTO(Review review) {
        return MemberResponseDTO.MyReviewPreViewDTO.builder()
                .storeName(review.getStore().getName())
                .score(review.getScore())
                .body(review.getBody())
                .createdAt(review.getCreatedAt().toLocalDate())
                .build();

    }

    public static MemberResponseDTO.MyReviewPreViewListDTO myReviewPreviewListDTO(Page<Review> myReviewList) {
        List<MemberResponseDTO.MyReviewPreViewDTO> dtoList = myReviewList.stream()
                .map(ReviewConverter::myReviewPreviewDTO)
                .collect(Collectors.toList());

        return MemberResponseDTO.MyReviewPreViewListDTO.builder()
                .myReviewList(dtoList)
                .listSize(dtoList.size())
                .totalPage(myReviewList.getTotalPages())
                .totalElements(myReviewList.getTotalElements())
                .isFirst(myReviewList.isFirst())
                .isLast(myReviewList.isLast())
                .build();

    }

}
