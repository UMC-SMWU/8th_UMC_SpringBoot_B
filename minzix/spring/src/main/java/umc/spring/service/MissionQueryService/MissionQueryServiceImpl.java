package umc.spring.service.MissionQueryService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.dto.MissionList.MissionListDto;
import umc.spring.repository.MissionRepository.MissionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;

    @Override
    @Transactional(readOnly = true)
    public List<MissionListDto> getMissionList(String regionName, Long cursorId, int pageSize) {
        System.out.println("regionName: " + regionName + ", cursorId: " + cursorId + ", pageSize: " + pageSize);
        return missionRepository.findMissionByRegion(regionName, cursorId, pageSize);
    }
}
