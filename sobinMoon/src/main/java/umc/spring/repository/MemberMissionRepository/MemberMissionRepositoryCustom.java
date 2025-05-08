package umc.spring.repository.MemberMissionRepository;

import umc.spring.domain.enums.MemberMissionStatus;
import umc.spring.web.dto.MemberMissionDto;

import java.util.List;

public interface MemberMissionRepositoryCustom {
    List<MemberMissionDto> findMemberMission(Long memberId, Long cursorId, MemberMissionStatus missionStatus, int limit);
}
