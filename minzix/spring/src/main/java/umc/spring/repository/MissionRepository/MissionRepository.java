package umc.spring.repository.MissionRepository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Mission;
import org.springframework.data.domain.Page;


public interface MissionRepository extends JpaRepository<Mission, Long>, MissionRepositoryCustom {
    Page<Mission> findAllByStoreId(Long storeId, Pageable pageable);
}