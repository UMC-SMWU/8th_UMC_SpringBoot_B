package umc.nnmrm.converter;

import org.springframework.data.domain.Page;
import umc.nnmrm.domain.Mission;
import umc.nnmrm.domain.mapping.MemberMission;
import umc.nnmrm.web.dto.MemberMission.MissionChallengeResponseDTO;
import umc.nnmrm.web.dto.Mission.MissionResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

// Converter
public class MissionChallengeConverter {

    public static MissionChallengeResponseDTO fromEntity(MemberMission memberMission) {
        return MissionChallengeResponseDTO.builder()
                .memberMissionId(memberMission.getId())
                .status(memberMission.getStatus().name())
                .createdAt(memberMission.getCreatedAt())
                .build();
    }

    public static MissionResponseDTO.MyMissionListDTO toMyMissionListDTO(Page<Mission> page) {
        List<MissionResponseDTO.MyMissionDTO> missionDTOList = page.getContent().stream()
                .map(mission -> MissionResponseDTO.MyMissionDTO.builder()
                        .missionId(mission.getId())
                        .missionSpec(mission.getMissionSpec())
                        .reward(mission.getReward())
                        .deadline(mission.getDeadline())
                        .storeName(mission.getStore().getName())
                        .build())
                .collect(Collectors.toList());

        return MissionResponseDTO.MyMissionListDTO.builder()
                .missions(missionDTOList)
                .listSize(missionDTOList.size())
                .totalPage(page.getTotalPages())
                .totalElements(page.getTotalElements())
                .isFirst(page.isFirst())
                .isLast(page.isLast())
                .build();
    }
}