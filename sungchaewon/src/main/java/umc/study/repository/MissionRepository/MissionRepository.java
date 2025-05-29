package umc.study.repository.MissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Mission;
import org.springframework.data.domain.Pageable;


public interface MissionRepository extends JpaRepository<Mission, Long> {
    Page<Mission> findByStoreId(Long storeId, Pageable pageable);
}
