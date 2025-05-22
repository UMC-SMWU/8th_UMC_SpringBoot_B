package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberMissionRequestDTO;
import umc.spring.web.dto.MemberMissionResponseDTO;

import java.time.LocalDateTime;

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
}
