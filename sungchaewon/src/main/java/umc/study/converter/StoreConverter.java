package umc.study.converter;

import umc.study.domain.Region;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;
import umc.study.web.dto.ReviewPreViewDTO;
import umc.study.web.dto.ReviewPreViewListDTO;

import java.util.List;
import java.util.stream.Collectors;

public class StoreConverter {

    public static Store toStore(StoreRequestDTO requestDTO, Region region) {
        return Store.builder()
                .name(requestDTO.getName())
                .address(requestDTO.getAddress())
                .score(requestDTO.getScore())
                .category(requestDTO.getCategory())
                .region(region)
                .build();
    }

    public static ReviewPreViewDTO reviewPreViewDTO(Review review){
        return ReviewPreViewDTO.builder()
                .id(review.getId())
                .score(review.getScore())
                .body(review.getBody())
                .build();
    }

    public static ReviewPreViewListDTO reviewPreViewListDTO(List<Review> reviewList){
        List<ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(StoreConverter::reviewPreViewDTO)
                .collect(Collectors.toList());

        return ReviewPreViewListDTO.builder()
                .reviews(reviewPreViewDTOList)
                .build();
    }
}
