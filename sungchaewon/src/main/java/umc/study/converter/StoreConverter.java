package umc.study.converter;

import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.web.dto.ReviewPreViewDTO;
import umc.study.web.dto.ReviewPreViewListDTO;
import umc.study.web.dto.StoreResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class StoreConverter {

    public static ReviewPreViewDTO reviewPreViewDTO(Review review){
        return ReviewPreViewDTO.builder()
                .id(review.getId())
                .score(Math.round(review.getScore()))
                .body(review.getBody())
                .nickname(review.getMember().getName())
                .createdAt(review.getCreatedAt().toLocalDate())
                .build();
    }

    public static ReviewPreViewListDTO reviewPreViewListDTO(List<Review> reviewList){
        List<ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(StoreConverter::reviewPreViewDTO)
                .collect(Collectors.toList());

        return ReviewPreViewListDTO.builder()
                .reviewList(reviewPreViewDTOList)
                .build();
    }

    public static StoreResponseDTO toStoreResponse(Store store) {
        return StoreResponseDTO.builder()
                .id(store.getId())
                .name(store.getName())
                .address(store.getAddress())
                .category(store.getCategory())
                .build();
    }
}