package umc.spring.repository.ReviewRepository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.*;

import java.time.LocalDateTime;


@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {

    private final EntityManager em;

    @Override
    public Review saveCustomReview(Long memberId, Long storeId, String body, Float score) {
        Member member = em.getReference(Member.class, memberId);
        Store store = em.getReference(Store.class, storeId);

        Review review = Review.builder()
                .member(member)
                .store(store)
                .body(body)
                .score(score)
                .build();

        em.persist(review);
        return review;
    }

}
