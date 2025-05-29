package umc.study.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import umc.study.converter.MissionConverter;
import umc.study.domain.Mission;
import umc.study.repository.MissionRepository.MissionRepository;

import org.springframework.data.domain.Pageable;
import umc.study.web.dto.MissionListDTO;

@Service
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;

    @Override
    public MissionListDTO getMissionsByStore(Long storeId, Pageable pageable) {
        Page<Mission> missions = missionRepository.findByStoreId(storeId, pageable);
        return MissionConverter.toMissionListDTO(missions);
    }
}
