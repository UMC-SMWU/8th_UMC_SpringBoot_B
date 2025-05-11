package umc.spring.repository.MemberMissionRepository;

import umc.spring.dto.memberMission.MemberMissionDto;

import java.util.List;

public interface MemberMissionRepositoryCustom {
    List<MemberMissionDto> findUserMissions(Long userId, Long cursorId, int pageSize);
}
