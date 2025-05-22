package umc.spring.repository.MemberMissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Mission;

public interface MemberMissionRepository extends JpaRepository<Mission, Long>, MemberMissionRepositoryCustom {
}

