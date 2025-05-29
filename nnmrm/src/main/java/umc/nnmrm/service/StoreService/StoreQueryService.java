package umc.nnmrm.service.StoreService;

import org.springframework.data.domain.Page;
import umc.nnmrm.domain.Mission;
import umc.nnmrm.domain.Review;

public interface StoreQueryService {

    Page<Review> getReviewList(Long StoreId, Integer page);
    Page<Mission> getMissionList(Long storeId, Integer page);

}