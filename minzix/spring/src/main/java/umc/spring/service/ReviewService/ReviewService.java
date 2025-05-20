package umc.spring.service.ReviewService;

import org.springframework.data.domain.Pageable;
import umc.spring.dto.Review.ReviewRequestDTO;
import umc.spring.dto.Review.ReviewResponseDTO;

import java.util.List;

//public interface ReviewService {
//    void addReview(Long storeId, Long userId, Integer score, String content, String imgUrl);
//}
public interface ReviewService {
    void createReview(ReviewRequestDTO request);
    ReviewResponseDTO.MyReviewListDTO getMyReviews(Long memberId, Pageable pageable);
}


