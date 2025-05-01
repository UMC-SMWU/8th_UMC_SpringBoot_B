package umc.spring.service.ReviewService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.repository.ReviewRepository.ReviewRepository;

@RequiredArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Override
    @Transactional
    public void addReview(Long storeId, Long userId, Integer score, String content, String imgUrl) {
        System.out.println("storeId: " + storeId + ", userId: " + userId + ", score: " + score);
        System.out.println("content: " + content + ", imgUrl: " + imgUrl);

        reviewRepository.insertReview(storeId, userId, score, content, imgUrl);
    }
}
