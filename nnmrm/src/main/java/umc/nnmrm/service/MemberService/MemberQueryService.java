package umc.nnmrm.service.MemberService;

import umc.nnmrm.dto.MyPageInfoDto;

public interface MemberQueryService {
    MyPageInfoDto getMyPageInfo(Long memberId);
}
