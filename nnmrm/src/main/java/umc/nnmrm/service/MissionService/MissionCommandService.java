package umc.nnmrm.service.MissionService;

import umc.nnmrm.web.dto.Mission.MissionRequestDTO;
import umc.nnmrm.web.dto.Mission.MissionResponseDTO;

public interface MissionCommandService {

    MissionResponseDTO createMission(Long storeId, MissionRequestDTO requestDTO);
}
