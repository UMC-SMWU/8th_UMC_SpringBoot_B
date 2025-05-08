package umc.nnmrm.service.MemberMissionService;

import umc.nnmrm.dto.MemberMissionResponseDto;

import java.util.List;

public interface MemberMissionQueryService {
    List<MemberMissionResponseDto> getMemberMissions(Long memberId, String cursor, int limit);
}
