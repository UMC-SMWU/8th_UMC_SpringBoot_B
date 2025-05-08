package umc.spring.service.ReviewService;

import umc.spring.domain.Review;

public interface ReviewService {
    Review createReview(Long memberId, Long storeId, String body, Float score);
}
