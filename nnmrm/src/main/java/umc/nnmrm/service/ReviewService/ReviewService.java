package umc.nnmrm.service.ReviewService;

import org.springframework.data.domain.Page;
import umc.nnmrm.domain.Review;
import umc.nnmrm.web.dto.Review.ReviewQueryResponseDTO;
import umc.nnmrm.web.dto.Review.ReviewCreateRequestDTO;
import umc.nnmrm.web.dto.Review.ReviewCreateResponseDTO;

public interface ReviewService {
    ReviewQueryResponseDTO writeReview(Long memberId, Long storeId, Float score, String body);

    ReviewCreateResponseDTO createReview(Long storeId, ReviewCreateRequestDTO requestDTO);

    Page<Review> getMyReviews(Long member, int page);
}