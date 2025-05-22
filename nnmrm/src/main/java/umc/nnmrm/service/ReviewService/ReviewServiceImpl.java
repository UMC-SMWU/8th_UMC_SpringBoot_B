package umc.nnmrm.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.nnmrm.apiPayload.code.status.ErrorStatus;
import umc.nnmrm.apiPayload.exception.handler.MemberHandler;
import umc.nnmrm.apiPayload.exception.handler.StoreHandler;
import umc.nnmrm.converter.ReviewConverter;
import umc.nnmrm.domain.Member;
import umc.nnmrm.domain.Review;
import umc.nnmrm.domain.Store;
import umc.nnmrm.web.dto.Review.ReviewQueryResponseDTO;
import umc.nnmrm.repository.MemberRepository.MemberRepository;
import umc.nnmrm.repository.ReviewRepository.ReviewRepository;
import umc.nnmrm.repository.StoreRepository.StoreRepository;
import umc.nnmrm.web.dto.Review.ReviewRequestDTO;
import umc.nnmrm.web.dto.Review.ReviewResponseDTO;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    @Override
    public ReviewQueryResponseDTO writeReview(Long memberId, Long storeId, Float score, String body) {
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
        return new ReviewQueryResponseDTO(
                review.getId(),
                member.getName(),
                store.getName(),
                review.getScore(),
                review.getBody()
        );
    }

    @Transactional
    public ReviewResponseDTO createReview(Long storeId, ReviewRequestDTO requestDTO) {

        Member member = memberRepository.findById(1L)
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        Review review = ReviewConverter.toEntity(requestDTO, member, store);

        return ReviewConverter.fromEntity(reviewRepository.save(review));
    }
}