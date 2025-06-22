package umc.nnmrm.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import umc.nnmrm.web.dto.Member.MemberResponseDTO;
import umc.nnmrm.web.dto.Member.MyPageInfoDto;

public interface MemberQueryService {
    MyPageInfoDto getMyPageInfo(Long memberId);
    MemberResponseDTO.MemberInfoDTO getMemberInfo(HttpServletRequest request);
}
