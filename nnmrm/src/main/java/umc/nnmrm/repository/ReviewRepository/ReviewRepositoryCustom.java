package umc.nnmrm.repository.ReviewRepository;

import umc.nnmrm.web.dto.Review.ReviewResponseDto;

public interface ReviewRepositoryCustom {
    ReviewResponseDto findReviewWithMemberAndStore(Long reviewId);
}