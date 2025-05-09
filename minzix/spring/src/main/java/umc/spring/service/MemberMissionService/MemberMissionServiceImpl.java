package umc.spring.service.MemberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.dto.memberMission.MemberMissionDto;
import umc.spring.repository.MemberMissionRepository.MemberMissionRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberMissionServiceImpl implements MemberMissionService {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public List<MemberMissionDto> getUserMissions(Long userId, Long cursorId, int pageSize) {
        List<MemberMissionDto> results = memberMissionRepository.findUserMissions(userId, cursorId, pageSize);

        System.out.println("userId = " + userId + ", cursorId = " + cursorId + ", pageSize = " + pageSize);
        results.forEach(mission -> System.out.println("MemberMission: " + mission));
        System.out.println("결과 개수: " + results.size());

        return results;
    }


}

