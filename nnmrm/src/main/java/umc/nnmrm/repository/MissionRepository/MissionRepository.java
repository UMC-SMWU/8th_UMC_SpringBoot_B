package umc.nnmrm.repository.MissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.nnmrm.domain.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long>, MissionRepositoryCustom {
}
