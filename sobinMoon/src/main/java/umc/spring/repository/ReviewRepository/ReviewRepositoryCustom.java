package umc.spring.repository.ReviewRepository;

import umc.spring.domain.Review;

import java.time.LocalDateTime;

public interface ReviewRepositoryCustom {
    Review addReview(Long memberId, Long storeId, String body, Float score);
}
