package umc.spring.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.repository.MemberRepository.MemberRepository;
import umc.spring.web.dto.MyPageInfoDto;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public MyPageInfoDto getMyPageInfo(Long memberId) {
        return memberRepository.findMyPageInfoById(memberId);
    }
}