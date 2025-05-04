package umc.spring.service.MemberMissionService;

import umc.spring.web.dto.MemberMissionDto;

import java.util.List;

public interface MemberMissionService {
    List<MemberMissionDto> getMemberMissions(Long memberId, Long cursorId, int limit);
}
