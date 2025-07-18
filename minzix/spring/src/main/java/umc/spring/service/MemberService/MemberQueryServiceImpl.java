package umc.spring.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.exception.handler.MemberHandler;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.config.security.jwt.JwtTokenProvider;
import umc.spring.converter.MemberConverter;
import umc.spring.domain.Member;
import umc.spring.dto.Member.MemberInfoDto;
import umc.spring.dto.Member.MemberResponseDTO;
import umc.spring.repository.MemberRepository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberQueryServiceImpl implements MemberQueryService{

    private final MemberRepository memberRepository;
    private final JwtTokenProvider jwtTokenProvider;


    @Override
    public MemberInfoDto getUserInfo(Long userId) {
        MemberInfoDto result = memberRepository.findUserInfoById(userId);
        System.out.println("User Info: " + result);
        return result;
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
