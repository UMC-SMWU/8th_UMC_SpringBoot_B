package umc.nnmrm.service.MemberService;

import umc.nnmrm.domain.Member;
import umc.nnmrm.web.dto.Member.MemberRequestDTO;
import umc.nnmrm.web.dto.Member.MemberResponseDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDto request);
    MemberResponseDTO.LoginResultDTO loginMember(MemberRequestDTO.LoginRequestDTO request);
}
