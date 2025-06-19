package umc.spring.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import umc.spring.dto.Member.MemberInfoDto;
import umc.spring.dto.Member.MemberResponseDTO;

public interface MemberQueryService {
    MemberInfoDto getUserInfo(Long userId);

    MemberResponseDTO.MemberInfoDTO getMemberInfo(HttpServletRequest request);


}
