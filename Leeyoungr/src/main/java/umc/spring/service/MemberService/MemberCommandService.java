package umc.spring.service.MemberService;

import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.web.dto.Request.MemberRequestDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDto request);
    Review createReview(MemberRequestDTO.ReviewDto request);
}
