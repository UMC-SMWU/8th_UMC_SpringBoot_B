package umc.spring.repository.MissionRepository;

import umc.spring.web.dto.HomeMissionDto;

import java.util.List;

public interface MissionRepositoryCustom {
    List<HomeMissionDto> findMissionsByRegion(Long memberId, String regionName, Long cursorId, int limit);
}