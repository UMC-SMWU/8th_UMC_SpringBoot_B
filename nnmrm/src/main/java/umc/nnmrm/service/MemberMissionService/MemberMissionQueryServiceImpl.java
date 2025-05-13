package umc.nnmrm.service.MemberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.nnmrm.web.dto.MemberMission.MemberMissionResponseDto;
import umc.nnmrm.repository.MemberMissionRepository.MemberMissionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberMissionQueryServiceImpl implements MemberMissionQueryService {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public List<MemberMissionResponseDto> getMemberMissions(Long memberId, String cursor, int limit) {
        return memberMissionRepository.findMemberMissionsWithPaging(memberId, cursor, limit);
    }
}
