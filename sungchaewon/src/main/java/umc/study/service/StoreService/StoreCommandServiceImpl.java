package umc.study.service.StoreService;

import umc.study.web.dto.StoreRequestDTO;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Store;
import umc.study.repository.StoreRepository.StoreRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;

    @Override
    public void addStore(StoreRequestDTO storeRequestDTO) {
        Store store = Store.builder()
                .name(storeRequestDTO.getName())
                .address(storeRequestDTO.getAddress())
                .score(storeRequestDTO.getScore())
                .category(storeRequestDTO.getCategory())
                .build();
        storeRepository.save(store);
    }
}
