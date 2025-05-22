package umc.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.domain.Mission;
import umc.study.repository.MissionRepository.MissionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MissionService {

    private final MissionRepository missionRepository;

    public List<Mission> getMissionsByMember(Long memberId, int page, int size) {
        int offset = page * size;
        return missionRepository.findMissionsByMember(memberId, size, offset);
    }
}
