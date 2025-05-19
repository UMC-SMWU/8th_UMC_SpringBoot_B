package umc.spring.service.MemberCommandService;

import umc.spring.domain.Member;
import umc.spring.dto.Member.MemberRequestDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDto request);

}
