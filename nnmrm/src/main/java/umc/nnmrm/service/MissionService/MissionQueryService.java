package umc.nnmrm.service.MissionService;

import umc.nnmrm.dto.HomeResponseDto;

import java.util.List;

public interface MissionQueryService {
    List<HomeResponseDto> getAvailableMissions(Long memberId, Long regionId, String cursor, int limit);
}