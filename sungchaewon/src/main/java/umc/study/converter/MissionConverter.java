package umc.study.converter;

import org.springframework.data.domain.Page;
import java.util.stream.Collectors;
import umc.study.web.dto.MissionListDTO;
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

    public static MissionListDTO toMissionListDTO(Page<Mission> missionPage) {
        return MissionListDTO.builder()
                .missionList(
                        missionPage.getContent().stream().map(mission ->
                                MissionListDTO.MissionDTO.builder()
                                        .id(mission.getId())
                                        .spec(mission.getMissionSpec())
                                        .reward(String.valueOf(mission.getReward()))
                                        .status(String.valueOf(mission.getStatus()))
                                        .build()
                        ).collect(Collectors.toList())
                )
                .listSize(missionPage.getSize())
                .totalPage(missionPage.getTotalPages())
                .totalElements(missionPage.getTotalElements())
                .isFirst(missionPage.isFirst())
                .isLast(missionPage.isLast())
                .build();
    }
}
