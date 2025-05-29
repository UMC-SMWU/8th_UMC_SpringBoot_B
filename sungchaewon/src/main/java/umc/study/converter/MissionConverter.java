package umc.study.converter;

import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.web.dto.MissionRequestDTO;

public class MissionConverter {
    public static Mission toMission(MissionRequestDTO dto, Store store) {
        return Mission.builder()
                .store(store)
                .missionSpec(dto.getMissionSpec())
                .reward(dto.getReward())
                .deadline(dto.getDeadline())
                .build();
    }
}
