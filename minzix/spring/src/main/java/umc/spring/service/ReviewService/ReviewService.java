package umc.spring.service.ReviewService;

import umc.spring.dto.Review.ReviewRequestDTO;

//public interface ReviewService {
//    void addReview(Long storeId, Long userId, Integer score, String content, String imgUrl);
//}
public interface ReviewService {
    void createReview(ReviewRequestDTO request);
}


