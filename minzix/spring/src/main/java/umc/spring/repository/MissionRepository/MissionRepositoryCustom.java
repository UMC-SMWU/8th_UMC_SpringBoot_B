package umc.spring.repository.MissionRepository;

import umc.spring.dto.MissionList.MissionListDto;

import java.util.List;

public interface MissionRepositoryCustom {
    List<MissionListDto> findMissionByRegion(String regionName, Long cursorId, int pageSize);
}
