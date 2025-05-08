package umc.spring.repository.MemberMissionRepository;

import umc.spring.web.dto.MemberMissionDto;

import java.util.List;

public interface MemberMissionRepositoryCustom {
    List<MemberMissionDto> findMemberMissions(Long memberId, Long cursorId, int limit);
}