package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.Response.MemberResponseDTO;

import java.util.List;

public class MemberMissionConverter {

    public static MemberResponseDTO.ChallengingMissionPreviewDTO toChallengingMissionPreviewDTO(MemberMission memberMission) {
        return MemberResponseDTO.ChallengingMissionPreviewDTO.builder()
                .memberMissionId(memberMission.getId())
                .missionSpec(memberMission.getMission().getMissionSpec())
                .reward(memberMission.getMission().getReward())
                .deadline(memberMission.getMission().getDeadline())
                .build();
    }

    public static MemberResponseDTO.ChallengingMissionPreviewListDTO toChallengingMissionPreviewListDTO(Page<MemberMission> memberMissionList) {
        List<MemberResponseDTO.ChallengingMissionPreviewDTO> missionPreviewDTOList = memberMissionList.stream()
                .map(MemberMissionConverter::toChallengingMissionPreviewDTO)
                .toList();

        return MemberResponseDTO.ChallengingMissionPreviewListDTO.builder()
                .status("CHALLENGING")
                .myMissionList(missionPreviewDTOList)
                .listSize(missionPreviewDTOList.size())
                .totalPage(memberMissionList.getTotalPages())
                .totalElements(memberMissionList.getTotalElements())
                .isFirst(memberMissionList.isFirst())
                .isLast(memberMissionList.isLast())
                .build();
    }
}
