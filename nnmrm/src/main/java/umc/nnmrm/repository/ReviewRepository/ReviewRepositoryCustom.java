package umc.nnmrm.repository.ReviewRepository;

import umc.nnmrm.dto.ReviewResponseDto;

public interface ReviewRepositoryCustom {
    ReviewResponseDto findReviewWithMemberAndStore(Long reviewId);
}