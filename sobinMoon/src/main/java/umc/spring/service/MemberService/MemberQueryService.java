package umc.spring.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Page;
import umc.spring.domain.Review;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberResponseDTO;

public interface MemberQueryService {
    boolean isExistById(Long memberId);

    Page<Review> getReviewList(Long memberId, Integer page);

    Page<MemberMission> getChallengingMissionList(Long memberId, Integer page);

    MemberResponseDTO.MemberInfoDTO getMemberInfo(HttpServletRequest request);
}
