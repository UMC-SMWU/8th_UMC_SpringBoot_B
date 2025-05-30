package umc.study.service.MemberMissionService;

import org.springframework.data.domain.Pageable;
import umc.study.web.dto.OngoingMissionListDTO;

public interface MemberMissionQueryService {
    OngoingMissionListDTO getOngoingMissions(Long memberId, Pageable pageable);
    void completeMission(Long memberId, Long memberMissionId); // ← 추가
}
