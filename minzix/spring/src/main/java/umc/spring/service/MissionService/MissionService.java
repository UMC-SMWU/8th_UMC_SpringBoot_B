package umc.spring.service.MissionService;

import org.springframework.data.domain.Pageable;
import umc.spring.dto.Mission.MissionJoinRequestDTO;
import umc.spring.dto.Mission.MissionRequestDTO;
import umc.spring.dto.Mission.MissionResponseDTO;

public interface MissionService {
    void createMission(MissionRequestDTO request);

    void joinMission(MissionJoinRequestDTO request);

    MissionResponseDTO.MissionListDTO getMissionsByStore(Long storeId, Pageable pageable);


}

