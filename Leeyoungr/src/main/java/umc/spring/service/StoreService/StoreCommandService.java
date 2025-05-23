package umc.spring.service.StoreService;

import umc.spring.domain.Mission;
import umc.spring.web.dto.Request.StoreRequestDTO;

public interface StoreCommandService {
    Mission createMission(StoreRequestDTO.MissionDto requestDto);
}
