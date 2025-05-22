package umc.spring.service.MemberMissionService;

import umc.spring.dto.memberMission.MemberMissionDto;

import java.util.List;

public interface MemberMissionService {
    List<MemberMissionDto> getUserMissions(Long userId, Long cursorId, int pageSize);
}
