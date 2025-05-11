package umc.spring.service.MemberService;

import umc.spring.web.dto.MyPageInfoDto;

public interface MemberService {
    MyPageInfoDto getMyPageInfo(Long memberId);
}