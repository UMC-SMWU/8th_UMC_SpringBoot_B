package umc.nnmrm.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.nnmrm.dto.HomeResponseDto;
import umc.nnmrm.repository.MissionRepository.MissionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;

    @Override
    public List<HomeResponseDto> getAvailableMissions(Long memberId, Long regionId, String cursor, int limit) {
        return missionRepository.findAvailableMissions(memberId, regionId, cursor, limit);
    }
}