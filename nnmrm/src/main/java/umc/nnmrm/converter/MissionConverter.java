package umc.nnmrm.converter;

import umc.nnmrm.domain.Mission;
import umc.nnmrm.domain.Store;
import umc.nnmrm.web.dto.Mission.MissionRequestDTO;
import umc.nnmrm.web.dto.Mission.MissionResponseDTO;

public class MissionConverter {

    public static Mission toEntity(Store store, MissionRequestDTO dto) {
        return Mission.builder()
                .reward(dto.getReward())
                .deadline(dto.getDeadline())
                .missionSpec(dto.getMissionSpec())
                .store(store)
                .build();
    }

    public static MissionResponseDTO fromEntity(Mission mission) {
        return MissionResponseDTO.builder()
                .missionId(mission.getId())
                .createdAt(mission.getCreatedAt())
                .build();
    }
}