package umc.nnmrm.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.nnmrm.apiPayload.exception.handler.StoreHandler;
import umc.nnmrm.converter.MissionConverter;
import umc.nnmrm.apiPayload.code.status.ErrorStatus;
import umc.nnmrm.domain.Mission;
import umc.nnmrm.domain.Store;
import umc.nnmrm.repository.MissionRepository.MissionRepository;
import umc.nnmrm.repository.StoreRepository.StoreRepository;
import umc.nnmrm.web.dto.Mission.MissionRequestDTO;
import umc.nnmrm.web.dto.Mission.MissionResponseDTO;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    @Transactional
    public MissionResponseDTO createMission(Long storeId, MissionRequestDTO requestDTO) {

        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        Mission mission = MissionConverter.toEntity(store, requestDTO);

        return MissionConverter.fromEntity(missionRepository.save(mission));
    }

}
