package umc.spring.repository.ReviewRepository;

import umc.spring.domain.Review;

public interface ReviewRepositoryCustom {
    Review saveCustomReview(Long memberId, Long storeId, String body, Float score);
}
