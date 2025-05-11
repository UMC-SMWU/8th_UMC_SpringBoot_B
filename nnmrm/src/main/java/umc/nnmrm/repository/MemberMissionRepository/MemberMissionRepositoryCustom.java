package umc.nnmrm.repository.MemberMissionRepository;

import umc.nnmrm.dto.MemberMissionResponseDto;

import java.util.List;

public interface MemberMissionRepositoryCustom {
    List<MemberMissionResponseDto> findMemberMissionsWithPaging(Long memberId, String cursor, int limit);
}