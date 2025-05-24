package umc.spring.service.StoreService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Review;
import umc.spring.dto.Store.StoreRequestDTO;

public interface StoreService {
    void createStore(StoreRequestDTO request);

    Page<Review> getReviewList(Long StoreId, Integer page);

}
