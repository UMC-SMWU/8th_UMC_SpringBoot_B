package umc.nnmrm.converter;

import umc.nnmrm.domain.mapping.MemberMission;
import umc.nnmrm.web.dto.MemberMission.MissionChallengeResponseDTO;

// Converter
public class MissionChallengeConverter {

    public static MissionChallengeResponseDTO fromEntity(MemberMission memberMission) {
        return MissionChallengeResponseDTO.builder()
                .memberMissionId(memberMission.getId())
                .status(memberMission.getStatus().name())
                .createdAt(memberMission.getCreatedAt())
                .build();
    }
}