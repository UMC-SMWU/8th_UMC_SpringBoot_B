package umc.spring.service.MemberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.repository.MemberMissionRepository.MemberMissionRepository;
import umc.spring.web.dto.MemberMissionDto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberMissionServiceImpl implements MemberMissionService {

    private final MemberMissionRepository memberMissionRepository;

    @Transactional(readOnly = true)
    @Override
    public List<MemberMissionDto> getMemberMissions(Long memberId, Long cursorId, int limit) {
        return memberMissionRepository.findMemberMissions(memberId, cursorId, limit);
    }
}