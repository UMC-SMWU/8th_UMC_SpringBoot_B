package umc.spring.service.MemberService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Review;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MyPageInfoDto;

public interface MemberQueryService {
    MyPageInfoDto getMyPageInfo(Long memberId);
    Page<Review> getMyReviewList(Integer page);
    Page<MemberMission> getChallengingMissionList(Integer page);
}