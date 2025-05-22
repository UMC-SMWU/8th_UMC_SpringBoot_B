package umc.spring.repository.ReviewRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import umc.spring.domain.*;

@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {

    private final JPAQueryFactory queryFactory;
    private final EntityManager em;

    @Override
    public void insertReview(Long storeId, Long userId, Integer score, String content, String imgUrl) {
        QReview review = QReview.review;
        QStore store = QStore.store;
        QMember member = QMember.member;

        Review newReview = Review.builder()
                .store(em.getReference(Store.class, storeId))
                .member(em.getReference(Member.class, userId))
                .score(Float.valueOf(score))
                .body(content)
                .build();

        em.persist(newReview);
    }
}

