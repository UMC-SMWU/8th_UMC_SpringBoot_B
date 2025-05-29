package umc.nnmrm.service.StoreService;

import org.springframework.data.domain.Page;
import umc.nnmrm.domain.Review;

public interface StoreQueryService {

    // ... 다른 코드들

    Page<Review> getReviewList(Long StoreId, Integer page);

}