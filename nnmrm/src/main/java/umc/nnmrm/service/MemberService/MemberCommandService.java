package umc.nnmrm.service.MemberService;

import umc.nnmrm.domain.Member;
import umc.nnmrm.web.dto.Member.MemberRequestDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDto request);
}
