package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.dto.Mission.MissionResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class MissionConverter {

    public static MissionResponseDTO.MissionDTO toMissionDTO(Mission mission) {
        return MissionResponseDTO.MissionDTO.builder()
                .reward(mission.getReward())
                .deadline(mission.getDeadline())
                .missionSpec(mission.getMissionSpec())
                .createdAt(mission.getCreatedAt())
                .build();
    }

    public static MissionResponseDTO.MissionListDTO toMissionListDTO(Page<Mission> missionPage) {
        List<MissionResponseDTO.MissionDTO> missionList = missionPage.stream()
                .map(MissionConverter::toMissionDTO)
                .collect(Collectors.toList());

        return MissionResponseDTO.MissionListDTO.builder()
                .isFirst(missionPage.isFirst())
                .isLast(missionPage.isLast())
                .totalPage(missionPage.getTotalPages())
                .totalElements(missionPage.getTotalElements())
                .listSize(missionList.size())
                .missionList(missionList)
                .build();
    }
}
