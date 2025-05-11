package umc.nnmrm.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.nnmrm.domain.Member;
import umc.nnmrm.domain.Review;
import umc.nnmrm.domain.Store;
import umc.nnmrm.dto.ReviewResponseDto;
import umc.nnmrm.repository.MemberRepository.MemberRepository;
import umc.nnmrm.repository.ReviewRepository.ReviewRepository;
import umc.nnmrm.repository.StoreRepository.StoreRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    @Override
    public ReviewResponseDto writeReview(Long memberId, Long storeId, Float score, String body) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 매장입니다."));

        Review review = Review.builder()
                .member(member)
                .store(store)
                .score(score)
                .body(body)
                .build();

        reviewRepository.save(review);
        return new ReviewResponseDto(
                review.getId(),
                member.getName(),
                store.getName(),
                review.getScore(),
                review.getBody()
        );
    }
}