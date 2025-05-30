package umc.nnmrm.service.MemberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.nnmrm.apiPayload.code.status.ErrorStatus;
import umc.nnmrm.domain.Member;
import umc.nnmrm.domain.Mission;
import umc.nnmrm.domain.enums.MissionStatus;
import umc.nnmrm.domain.mapping.MemberMission;
import umc.nnmrm.repository.MemberMissionRepository.MemberMissionRepository;
import umc.nnmrm.repository.MemberRepository.MemberRepository;
import umc.nnmrm.repository.MissionRepository.MissionRepository;
import umc.nnmrm.web.dto.MemberMission.MissionChallengeResponseDTO;
import umc.nnmrm.apiPayload.exception.handler.MissionHandler;
import umc.nnmrm.apiPayload.exception.handler.MemberHandler;
import umc.nnmrm.converter.MissionChallengeConverter;


@Service
@RequiredArgsConstructor
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService {

    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Transactional
    public MissionChallengeResponseDTO challengeMission(Long missionId) {

        Member member = memberRepository.findById(1L)
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));


        MemberMission memberMission = MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(MissionStatus.CHALLENGING)
                .build();

        return MissionChallengeConverter.fromEntity(memberMissionRepository.save(memberMission));
    }

    @Override
    public Page<Mission> getMyInProgressMissions(Long memberId, int page) {
        Pageable pageable = PageRequest.of(page, 10, Sort.by(Sort.Direction.DESC, "createdAt"));
        return memberMissionRepository
                .findAllByMember_IdAndStatus(memberId, MissionStatus.CHALLENGING, pageable)
                .map(MemberMission::getMission);
    }
}
