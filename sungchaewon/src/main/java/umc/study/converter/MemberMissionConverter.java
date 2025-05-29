package umc.study.converter;

import org.springframework.data.domain.Page;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.enums.mapping.MemberMission;
import umc.study.web.dto.OngoingMissionDTO;
import umc.study.web.dto.OngoingMissionListDTO;

import java.util.List;
import java.util.stream.Collectors;

public class MemberMissionConverter {

    public static MemberMission toMemberMission(Member member, Mission mission) {
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(MissionStatus.CHALLENGING)
                .build();
    }

    public static OngoingMissionDTO toOngoingDTO(MemberMission memberMission) {
        Mission mission = memberMission.getMission();
        return OngoingMissionDTO.builder()
                .missionId(mission.getId())
                .missionSpec(mission.getMissionSpec())
                .reward(mission.getReward())
                .deadline(mission.getDeadline())
                .storeName(mission.getStore().getName())
                .build();
    }

    public static OngoingMissionListDTO toOngoingListDTO(Page<MemberMission> page) {
        List<OngoingMissionDTO> dtoList = page.getContent().stream()
                .map(MemberMissionConverter::toOngoingDTO)
                .collect(Collectors.toList());

        return OngoingMissionListDTO.builder()
                .missions(dtoList)
                .listSize(dtoList.size())
                .totalPage(page.getTotalPages())
                .totalElements(page.getTotalElements())
                .isFirst(page.isFirst())
                .isLast(page.isLast())
                .build();
    }
}
