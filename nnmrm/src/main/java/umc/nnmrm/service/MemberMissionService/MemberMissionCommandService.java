package umc.nnmrm.service.MemberMissionService;

import org.springframework.data.domain.Page;
import umc.nnmrm.domain.Mission;
import umc.nnmrm.domain.mapping.MemberMission;
import umc.nnmrm.web.dto.MemberMission.MissionChallengeResponseDTO;

public interface MemberMissionCommandService {
    MissionChallengeResponseDTO challengeMission(Long missionId);
    Page<Mission> getMyInProgressMissions(Long memberId, int page);
}
