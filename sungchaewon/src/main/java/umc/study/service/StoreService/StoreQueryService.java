package umc.study.service.StoreService;

import umc.study.domain.Store;
import umc.study.web.dto.ReviewPreViewListDTO;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);
    List<Store> findStoresByNameAndScore(String name, Float score);
    ReviewPreViewListDTO getReviewList(Long storeId, Integer page);
}
