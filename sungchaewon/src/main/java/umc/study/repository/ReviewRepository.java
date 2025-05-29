package umc.study.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    // 특정 가게(storeId)의 리뷰를 페이지네이션하여 조회
    Page<Review> findByStoreId(Long storeId, Pageable pageable);

    // 로그인한 사용자가 작성한 리뷰를 페이지네이션하여 조회
    Page<Review> findByMemberId(Long memberId, Pageable pageable);

}
