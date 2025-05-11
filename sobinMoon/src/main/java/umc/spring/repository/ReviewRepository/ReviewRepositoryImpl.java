package umc.spring.repository.ReviewRepository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.Member;
import umc.spring.domain.Store;
import umc.spring.domain.Review;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {

    private final EntityManager em;

    @Override
    public Review addReview(Long memberId, Long storeId, String body, Float score) {

        // 프록시 엔티티 객체를 조회
        Member member = em.getReference(Member.class, memberId);
        Store store = em.getReference(Store.class, storeId);

        // 빌더 패턴으로 객체 생성
        Review review = Review.builder()
                .member(member)
                .store(store)
                .body(body)
                .score(score)
                .build();

        // 엔티티를 영속화(저장)
        em.persist(review);

        return review;
    }
}
