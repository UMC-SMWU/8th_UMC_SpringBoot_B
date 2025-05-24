package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.dto.memberMission.MemberMissionResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class MemberMissionConverter {

    public static MemberMissionResponseDTO.InProgressMissionDTO toInProgressMissionDTO(MemberMission mm) {
        return MemberMissionResponseDTO.InProgressMissionDTO.builder()
                .missionSpec(mm.getMission().getMissionSpec())
                .reward(mm.getMission().getReward())
                .storeName(mm.getMission().getStore().getName())
                .missionStatus(mm.getMissionStatus().name())
                .build();
    }

    public static MemberMissionResponseDTO.InProgressMissionListDTO toInProgressMissionListDTO(Page<MemberMission> page) {
        List<MemberMissionResponseDTO.InProgressMissionDTO> missionList = page.stream()
                .map(MemberMissionConverter::toInProgressMissionDTO)
                .collect(Collectors.toList());

        return MemberMissionResponseDTO.InProgressMissionListDTO.builder()
                .isFirst(page.isFirst())
                .isLast(page.isLast())
                .totalPage(page.getTotalPages())
                .totalElements(page.getTotalElements())
                .listSize(missionList.size())
                .missionList(missionList)
                .build();
    }
}
