package umc.spring.service.MemberService;

import umc.spring.dto.Member.MemberInfoDto;

public interface MemberQueryService {
    MemberInfoDto getUserInfo(Long userId);

}
