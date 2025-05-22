package umc.nnmrm.repository.MissionRepository;

import umc.nnmrm.web.dto.Mission.HomeResponseDto;

import java.util.List;

public interface MissionRepositoryCustom {
    List<HomeResponseDto> findAvailableMissions(Long memberId, Long regionId, String cursor, int limit);
}