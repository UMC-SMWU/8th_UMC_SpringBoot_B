package umc.spring.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import umc.spring.domain.Review;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository.MemberMissionRepository;
import umc.spring.repository.MemberRepository.MemberRepository;
import umc.spring.repository.ReviewRepository.ReviewRepository;
import umc.spring.web.dto.MyPageInfoDto;

@Service
@RequiredArgsConstructor
public class MemberQueryServiceImpl implements MemberQueryService {

    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public MyPageInfoDto getMyPageInfo(Long memberId) {
        return memberRepository.findMyPageInfoById(memberId);
    }

    @Override
    public Page<Review> getMyReviewList(Integer page) {
        // jwtTokenProvider
        Long memberId = 1L; // 임시 사용
        return reviewRepository.findByMemberId(memberId, PageRequest.of(page, 10, Sort.by(Sort.Direction.DESC, "createdAt")
        ));
    }

    @Override
    public Page<MemberMission> getChallengingMissionList(Integer page) {
        Long memberId = 1L; // 임시 사용
        return memberMissionRepository.findAllByMemberIdAndStatus(memberId, MissionStatus.CHALLENGING, PageRequest.of(page, 10));
    }
}


