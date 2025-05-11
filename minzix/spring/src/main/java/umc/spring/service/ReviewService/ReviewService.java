package umc.spring.service.ReviewService;

public interface ReviewService {
    void addReview(Long storeId, Long userId, Integer score, String content, String imgUrl);
}

