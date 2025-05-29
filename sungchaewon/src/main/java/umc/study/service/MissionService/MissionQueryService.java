package umc.study.service.MissionService;

import umc.study.web.dto.MissionListDTO;
import org.springframework.data.domain.Pageable;

public interface MissionQueryService {
    MissionListDTO getMissionsByStore(Long storeId, Pageable pageable);
}
