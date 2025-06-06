package umc.spring.repository.MemberMissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;

import java.util.Optional;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long>, MemberMissionRepositoryCustom {
    Page<MemberMission> findAllByMemberIdAndMissionStatus(Long memberId, MissionStatus missionStatus, Pageable pageable);

    Optional<MemberMission> findByMemberIdAndMissionId(Long memberId, Long missionId);

}

