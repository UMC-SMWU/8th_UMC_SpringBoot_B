package umc.spring.service.MemberCommandService;

import jakarta.servlet.http.HttpServletRequest;
import umc.spring.domain.Member;
import umc.spring.dto.Member.MemberRequestDTO;
import umc.spring.dto.Member.MemberResponseDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDto request);

    MemberResponseDTO.LoginResultDTO loginMember(MemberRequestDTO.LoginRequestDTO request);
}
