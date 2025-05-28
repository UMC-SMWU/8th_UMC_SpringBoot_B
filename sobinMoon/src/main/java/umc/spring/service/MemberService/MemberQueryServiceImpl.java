package umc.spring.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.MemberHandler;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.domain.enums.MemberMissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository.MemberMissionRepository;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.ReviewRepository.ReviewRepository;

@Service
@RequiredArgsConstructor
public class MemberQueryServiceImpl implements MemberQueryService{
    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;
    private final MemberMissionRepository memberMissionRepository;

    public boolean isExistById(Long memberId) {
        return memberRepository.existsById(memberId);
    }

    @Override
    public Page<Review> getReviewList(Long StoreId, Integer page) {

        Member member = memberRepository.findById(StoreId).get();

        Page<Review> memberPage = reviewRepository.findAllByMember(member, PageRequest.of(page, 10));
        return memberPage;
    }

    @Override
    public Page<MemberMission> getChallengingMissionList(Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId).
                orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        return memberMissionRepository.findAllByMemberAndStatus(member, MemberMissionStatus.CHALLENGING, PageRequest.of(page, 10));
    }
}
