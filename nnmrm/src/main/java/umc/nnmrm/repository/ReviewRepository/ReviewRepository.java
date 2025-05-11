package umc.nnmrm.repository.ReviewRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.nnmrm.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
