package umc.nnmrm.repository.MemberMissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.nnmrm.domain.enums.MissionStatus;
import umc.nnmrm.domain.mapping.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long>, MemberMissionRepositoryCustom {
    boolean existsByMemberIdAndMissionId(Long memberId, Long missionId);
    Page<MemberMission> findAllByMember_IdAndStatus(Long memberId, MissionStatus status, Pageable pageable);
}