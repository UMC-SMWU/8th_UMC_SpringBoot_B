package umc.spring.service.MemberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.exception.handler.MemberMissionHandler;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.dto.memberMission.MemberMissionResponseDTO;
import umc.spring.repository.MemberMissionRepository.MemberMissionRepository;

@RequiredArgsConstructor
@Service
public class MemberMissionServiceImpl implements MemberMissionService {

    private final MemberMissionRepository memberMissionRepository;

//    @Override
//    public List<MemberMissionDto> getUserMissions(Long userId, Long cursorId, int pageSize) {
//        List<MemberMissionDto> results = memberMissionRepository.findUserMissions(userId, cursorId, pageSize);
//
//        System.out.println("userId = " + userId + ", cursorId = " + cursorId + ", pageSize = " + pageSize);
//        results.forEach(mission -> System.out.println("MemberMission: " + mission));
//        System.out.println("결과 개수: " + results.size());
//
//        return results;
//    }


    @Override
    public MemberMissionResponseDTO.InProgressMissionListDTO getInProgressMissions(Long memberId, Pageable pageable) {
        return MemberMissionConverter.toInProgressMissionListDTO(
                memberMissionRepository.findAllByMemberIdAndMissionStatus(memberId, MissionStatus.CHALLENGING, pageable)
        );
    }

    @Override
    public void completeMission(Long memberId, Long missionId) {
        MemberMission memberMission = memberMissionRepository
                .findByMemberIdAndMissionId(memberId, missionId)
                .orElseThrow(() -> new MemberMissionHandler(ErrorStatus.MEMBER_MISSION_NOT_FOUND));

        if (memberMission.getMissionStatus() == MissionStatus.COMPLETE) {
            throw new MemberMissionHandler(ErrorStatus.MISSION_ALREADY_COMPLETE);
        }

        memberMission.changeStatusToComplete();
    }


}

