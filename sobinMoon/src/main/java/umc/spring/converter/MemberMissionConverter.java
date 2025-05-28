package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberMissionRequestDTO;
import umc.spring.web.dto.MemberMissionResponseDTO;

import java.time.LocalDateTime;
import java.util.List;

public class MemberMissionConverter {
    public static MemberMissionResponseDTO.JoinResultDTO toJoinResultDTO(Long memberMissionId) {
        return MemberMissionResponseDTO.JoinResultDTO.builder()
                .memberMissionId(memberMissionId)
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static MemberMission toMemberMission(MemberMissionRequestDTO.JoinDTO request, Mission mission, Member member) {
        return MemberMission.builder()
                .mission(mission)
                .member(member)
                .build();
    }

    public static MemberMissionResponseDTO.ChallengingMissionPreviewDTO toChallengingMissionPreviewDTO(MemberMission memberMission) {
        return MemberMissionResponseDTO.ChallengingMissionPreviewDTO.builder()
                .memberMissionId(memberMission.getId())
                .missionId(memberMission.getMission().getId())
                .missionSpec(memberMission.getMission().getMissionSpec())
                .reward(memberMission.getMission().getReward())
                .deadline(memberMission.getMission().getDeadline())
                .status(memberMission.getStatus())
                .build();
    }

    public static MemberMissionResponseDTO.ChallengingMissionPreviewListDTO toChallengingMissionPreviewListDTO(Page<MemberMission> memberMissionList) {
        List<MemberMissionResponseDTO.ChallengingMissionPreviewDTO> missionPreviewDTOList = memberMissionList.stream()
                .map(MemberMissionConverter::toChallengingMissionPreviewDTO)
                .toList();

        return MemberMissionResponseDTO.ChallengingMissionPreviewListDTO.builder()
                .missionList(missionPreviewDTOList)
                .listSize(missionPreviewDTOList.size())
                .totalPage(memberMissionList.getTotalPages())
                .totalElements(memberMissionList.getTotalElements())
                .isFirst(memberMissionList.isFirst())
                .isLast(memberMissionList.isLast())
                .build();
    }
}
