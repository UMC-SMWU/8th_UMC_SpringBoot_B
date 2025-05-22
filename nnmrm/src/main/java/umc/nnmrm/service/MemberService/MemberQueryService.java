package umc.nnmrm.service.MemberService;

import umc.nnmrm.web.dto.Member.MyPageInfoDto;

public interface MemberQueryService {
    MyPageInfoDto getMyPageInfo(Long memberId);
}
