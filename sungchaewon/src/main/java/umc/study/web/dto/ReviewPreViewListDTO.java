package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

import umc.study.domain.Review;
import umc.study.web.dto.StoreResponseDTO.ReviewPreViewDTO;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewPreViewListDTO {

    private List<StoreResponseDTO.ReviewPreViewDTO> reviews;
}
