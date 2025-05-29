package umc.study.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.exception.BusinessException;
import umc.study.apiPayload.exception.handler.MissionHandler;
import umc.study.converter.MemberMissionConverter;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.enums.mapping.MemberMission;
import umc.study.repository.MemberMissionRepository;
import umc.study.repository.MemberRepository;
import umc.study.repository.MissionRepository.MissionRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class MissionChallengeService {

    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    public void challengeMission(Long memberId, Long missionId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new BusinessException(MissionHandler.MEMBER_NOT_FOUND));
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new BusinessException(MissionHandler.MISSION_NOT_FOUND));

        boolean alreadyChallenging = memberMissionRepository.existsByMemberAndMission(member, mission);
        if (alreadyChallenging) {
            throw new BusinessException(MissionHandler.ALREADY_CHALLENGED);
        }

        MemberMission memberMission = MemberMissionConverter.toMemberMission(member, mission);
        memberMissionRepository.save(memberMission);
    }
}
