package umc.study.repository.MissionRepository;


import umc.study.domain.Mission;
import java.util.List;

public interface MissionRepositoryCustom {
    List<Mission> findMissionsByMember(Long memberId, int limit, int offset);
}
