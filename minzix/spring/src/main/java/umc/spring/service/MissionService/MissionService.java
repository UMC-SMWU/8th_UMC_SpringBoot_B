package umc.spring.service.MissionService;

import umc.spring.dto.Mission.MissionJoinRequestDTO;
import umc.spring.dto.Mission.MissionRequestDTO;

public interface MissionService {
    void createMission(MissionRequestDTO request);

    void joinMission(MissionJoinRequestDTO request);

}

