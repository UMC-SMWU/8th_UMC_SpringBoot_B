package umc.spring.service.MissionQueryService;

import umc.spring.dto.MissionList.MissionListDto;

import java.util.List;

public interface MissionQueryService {
    List<MissionListDto> getMissionList(String regionName, Long cursorId, int pageSize);
}
