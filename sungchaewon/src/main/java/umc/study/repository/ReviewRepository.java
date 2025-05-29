package umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Review;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    // 특정 가게의 리뷰 목록 조회
    List<Review> findByStoreId(Long storeId);

    // 특정 회원이 작성한 리뷰 목록 조회
    List<Review> findByMemberId(Long memberId);
}
