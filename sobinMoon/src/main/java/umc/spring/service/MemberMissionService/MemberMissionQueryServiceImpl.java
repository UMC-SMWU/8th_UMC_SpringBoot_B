package umc.spring.service.MemberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.enums.MemberMissionStatus;
import umc.spring.repository.MemberMissionRepository.MemberMissionRepository;
import umc.spring.web.dto.MemberMissionDto;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberMissionQueryServiceImpl implements MemberMissionQueryService {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public List<MemberMissionDto> findMemberMission(Long memberId, Long cursorId, MemberMissionStatus missionStatus, int limit) {
        List<MemberMissionDto> memberMissionDtos = memberMissionRepository.findMemberMission(memberId, cursorId, missionStatus, limit);

        memberMissionDtos.forEach(System.out::println);

        return memberMissionDtos;
    }
}
