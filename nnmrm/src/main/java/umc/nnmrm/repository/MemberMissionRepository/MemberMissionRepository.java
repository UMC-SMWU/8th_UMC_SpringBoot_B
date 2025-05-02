package umc.nnmrm.repository.MemberMissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.nnmrm.domain.mapping.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long>, MemberMissionRepositoryCustom {
}