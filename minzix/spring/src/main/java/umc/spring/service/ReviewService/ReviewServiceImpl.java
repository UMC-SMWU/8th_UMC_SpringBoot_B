package umc.spring.service.ReviewService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.exception.handler.GeneralException;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.dto.Review.ReviewRequestDTO;
import umc.spring.repository.MemberRepository.MemberRepository;
import umc.spring.repository.ReviewRepository.ReviewRepository;
import umc.spring.repository.StoreRepository.StoreRepository;

//@RequiredArgsConstructor
//@Service
//public class ReviewServiceImpl implements ReviewService {
//
//    private final ReviewRepository reviewRepository;
//
//    @Override
//    @Transactional
//    public void addReview(Long storeId, Long userId, Integer score, String content, String imgUrl) {
//        System.out.println("storeId: " + storeId + ", userId: " + userId + ", score: " + score);
//        System.out.println("content: " + content + ", imgUrl: " + imgUrl);
//
//        reviewRepository.insertReview(storeId, userId, score, content, imgUrl);
//    }
//}
@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;

    private static final Long MOCK_MEMBER_ID = 1L;

    @Override
    @Transactional
    public void createReview(ReviewRequestDTO request) {
        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new GeneralException(ErrorStatus.STORE_NOT_FOUND));

        Member member = memberRepository.findById(MOCK_MEMBER_ID)
                .orElseThrow(() -> new GeneralException(ErrorStatus.MEMBER_NOT_FOUND));

        Review review = Review.builder()
                .body(request.getBody())
                .score(request.getScore())
                .store(store)
                .member(member)
                .build();

        reviewRepository.save(review);
    }
}
