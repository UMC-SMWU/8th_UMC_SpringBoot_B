package umc.nnmrm.service.ReviewService;

import umc.nnmrm.web.dto.Review.ReviewQueryResponseDTO;
import umc.nnmrm.web.dto.Review.ReviewRequestDTO;
import umc.nnmrm.web.dto.Review.ReviewResponseDTO;

public interface ReviewService {
    ReviewQueryResponseDTO writeReview(Long memberId, Long storeId, Float score, String body);

    ReviewResponseDTO createReview(Long storeId, ReviewRequestDTO requestDTO);
}