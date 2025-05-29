package umc.spring.service.MemberMissionService;

import org.springframework.data.domain.Pageable;
import umc.spring.dto.memberMission.MemberMissionDto;
import umc.spring.dto.memberMission.MemberMissionResponseDTO;

import java.util.List;

public interface MemberMissionService {
//    List<MemberMissionDto> getUserMissions(Long userId, Long cursorId, int pageSize);

    MemberMissionResponseDTO.InProgressMissionListDTO getInProgressMissions(Long memberId, Pageable pageable);

    void completeMission(Long memberId, Long missionId);

}
