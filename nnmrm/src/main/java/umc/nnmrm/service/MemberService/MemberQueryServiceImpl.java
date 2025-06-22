package umc.nnmrm.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.nnmrm.apiPayload.code.status.ErrorStatus;
import umc.nnmrm.apiPayload.exception.handler.MemberHandler;
import umc.nnmrm.config.security.jwt.JwtTokenProvider;
import umc.nnmrm.domain.Member;
import umc.nnmrm.web.dto.Member.MemberResponseDTO;
import umc.nnmrm.web.dto.Member.MyPageInfoDto;
import umc.nnmrm.repository.MemberRepository.MemberRepository;
import umc.nnmrm.converter.MemberConverter;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService {

    private final MemberRepository memberRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public MyPageInfoDto getMyPageInfo(Long memberId) {

        return memberRepository.getMyPageInfo(memberId);
    }

    @Override
    @Transactional(readOnly = true)
    public MemberResponseDTO.MemberInfoDTO getMemberInfo(HttpServletRequest request){
        Authentication authentication = jwtTokenProvider.extractAuthentication(request);
        String email = authentication.getName();

        Member member = memberRepository.findByEmail(email)
                .orElseThrow(()-> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        return MemberConverter.toMemberInfoDTO(member);
    }
}