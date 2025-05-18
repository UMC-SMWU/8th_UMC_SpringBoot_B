package umc.nnmrm.service.MemberMissionService;

import umc.nnmrm.web.dto.MemberMission.MissionChallengeResponseDTO;

public interface MemberMissionCommandService {
    MissionChallengeResponseDTO challengeMission(Long missionId);
}
