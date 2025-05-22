package umc.spring.service.MissionService;

import umc.spring.web.dto.HomeMissionDto;

import java.util.List;

public interface MissionService {
    List<HomeMissionDto> getMissionsByRegion(Long memberId, String regionName, Long cursorId, int limit);
}