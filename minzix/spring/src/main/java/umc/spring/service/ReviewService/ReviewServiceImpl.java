package umc.spring.service.ReviewService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.exception.handler.GeneralException;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.dto.Review.ReviewRequestDTO;
import umc.spring.dto.Review.ReviewResponseDTO;
import umc.spring.repository.MemberRepository.MemberRepository;
import umc.spring.repository.ReviewRepository.ReviewRepository;
import umc.spring.repository.StoreRepository.StoreRepository;

import java.util.List;
import java.util.stream.Collectors;

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


    @Override
    public List<ReviewResponseDTO.MyReviewDTO> getMyReviews(Long memberId) {
        return reviewRepository.findAllByMemberId(memberId).stream()
                .map(ReviewConverter::toMyReviewDTO)
                .collect(Collectors.toList());
    }
}
