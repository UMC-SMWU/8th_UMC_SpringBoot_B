package umc.nnmrm.repository.ReviewRepository;

import umc.nnmrm.web.dto.Review.ReviewQueryResponseDTO;

public interface ReviewRepositoryCustom {
    ReviewQueryResponseDTO findReviewWithMemberAndStore(Long reviewId);
}