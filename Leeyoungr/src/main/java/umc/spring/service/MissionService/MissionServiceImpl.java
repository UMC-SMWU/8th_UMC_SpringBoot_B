package umc.spring.service.MissionService;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.repository.MissionRepository.MissionRepository;
import umc.spring.web.dto.HomeMissionDto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MissionServiceImpl implements MissionService {

    private final MissionRepository missionRepository;

    @Override
    public List<HomeMissionDto> getMissionsByRegion(Long memberId, String regionName, Long cursorId, int limit) {
        return missionRepository.findMissionsByRegion(memberId, regionName, cursorId, limit);
    }
}