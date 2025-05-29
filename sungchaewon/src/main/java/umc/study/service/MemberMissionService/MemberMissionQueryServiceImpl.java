package umc.study.service.MemberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import umc.study.converter.MemberMissionConverter;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.enums.mapping.MemberMission;
import umc.study.repository.MemberMissionRepository;
import umc.study.web.dto.OngoingMissionListDTO;


@Service
@RequiredArgsConstructor
public class MemberMissionQueryServiceImpl implements MemberMissionQueryService {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public OngoingMissionListDTO getOngoingMissions(Long memberId, Pageable pageable) {
        Page<MemberMission> page = memberMissionRepository.findByMemberIdAndStatus(memberId, MissionStatus.CHALLENGING, pageable);
        return MemberMissionConverter.toOngoingListDTO(page);
    }
    @Override
    public void completeMission(Long memberId, Long memberMissionId) {
        MemberMission memberMission = memberMissionRepository.findById(memberMissionId)
                .orElseThrow(() -> new IllegalArgumentException("해당 미션이 존재하지 않습니다."));

        if (!memberMission.getMember().getId().equals(memberId)) {
            throw new IllegalArgumentException("해당 유저의 미션이 아닙니다.");
        }

        memberMission.setStatus(MissionStatus.COMPLETE);
        memberMissionRepository.save(memberMission);
    }
}