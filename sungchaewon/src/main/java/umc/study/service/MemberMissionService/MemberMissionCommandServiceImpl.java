
package umc.study.service.MemberMissionService;

import jakarta.transaction.Transactional;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.GeneralException;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.enums.mapping.MemberMission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.repository.MemberMissionRepository;

@Service
@RequiredArgsConstructor
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService {
    private final MemberMissionRepository memberMissionRepository;
    @Override
    @Transactional
    public void completeMission(Long memberMissionId) {
        MemberMission memberMission = memberMissionRepository.findById(memberMissionId)
                .orElseThrow(() -> new GeneralException(ErrorStatus.MEMBER_MISSION_NOT_FOUND));

        if (memberMission.getStatus() == MissionStatus.COMPLETE) {
            throw new GeneralException(ErrorStatus.ALREADY_COMPLETED);
        }

        memberMission.changeStatus(MissionStatus.COMPLETE);
    }
}
