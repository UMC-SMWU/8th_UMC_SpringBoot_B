package umc.study.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.domain.Mission;
import umc.study.repository.MissionRepository.MissionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MissionService {

    private final MissionRepository missionRepository;

    public org.springframework.data.domain.Page<Mission> getMissionsByStore(Long storeId, org.springframework.data.domain.Pageable pageable) {
        return missionRepository.findByStoreId(storeId, pageable);
    }

    public Mission getMissionOrThrow(Long missionId) {
        return missionRepository.findById(missionId)
                .orElseThrow(() -> new IllegalArgumentException("해당 미션을 찾을 수 없습니다: id=" + missionId));
    }
}
