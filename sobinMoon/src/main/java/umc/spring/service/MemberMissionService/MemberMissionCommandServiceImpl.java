package umc.spring.service.MemberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.MemberHandler;
import umc.spring.apiPayload.exception.handler.MissionHandler;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository.MemberMissionRepository;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.web.dto.MemberMissionRequestDTO;

@Service
@RequiredArgsConstructor
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService {

    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;

    @Override
    public MemberMission join(MemberMissionRequestDTO.JoinDTO request, Long missionId) {
        Member member = memberRepository.findById(request.getMemberId()).orElseThrow(
                () -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND)
        );

        Mission mission = missionRepository.findById(missionId).orElseThrow(
                () -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND)
        );

        boolean isMemberMissionExist = memberMissionRepository.existsByMemberAndMission(member, mission);

        if (isMemberMissionExist) {
            throw new MissionHandler(ErrorStatus.MEMBER_MISSION_ALREADY_EXIST);
        }

        MemberMission memberMission = MemberMissionConverter.toMemberMission(
                request,
                mission,
                member
        );

        return memberMissionRepository.save(memberMission);
    }
}
