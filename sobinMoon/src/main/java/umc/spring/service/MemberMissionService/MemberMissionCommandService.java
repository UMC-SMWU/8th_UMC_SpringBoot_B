package umc.spring.service.MemberMissionService;

import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberMissionRequestDTO;
import umc.spring.web.dto.MemberMissionResponseDTO;

public interface MemberMissionCommandService {
    MemberMission join(MemberMissionRequestDTO.JoinDTO request, Long missionId);
}
