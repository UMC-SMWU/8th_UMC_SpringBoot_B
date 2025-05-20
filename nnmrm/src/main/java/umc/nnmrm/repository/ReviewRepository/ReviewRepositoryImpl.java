package umc.nnmrm.repository.ReviewRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.nnmrm.domain.QMember;
import umc.nnmrm.domain.QReview;
import umc.nnmrm.domain.QStore;
import umc.nnmrm.web.dto.Review.ReviewQueryResponseDTO;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {

    private final JPAQueryFactory queryFactory;
    QReview review = QReview.review;
    QMember member = QMember.member;
    QStore store = QStore.store;

    @Override
    public ReviewQueryResponseDTO findReviewWithMemberAndStore(Long reviewId) {
        return queryFactory
                .select(Projections.constructor(ReviewQueryResponseDTO.class,
                        review.id,
                        member.name,
                        store.name,
                        review.score,
                        review.body
                ))
                .from(review)
                .join(review.member, member)
                .join(review.store, store)
                .where(review.id.eq(reviewId))
                .fetchOne();
    }
}