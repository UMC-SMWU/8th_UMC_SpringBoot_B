package umc.nnmrm.service.ReviewService;

import umc.nnmrm.dto.ReviewResponseDto;

public interface ReviewService {
    ReviewResponseDto writeReview(Long memberId, Long storeId, Float score, String body);
}