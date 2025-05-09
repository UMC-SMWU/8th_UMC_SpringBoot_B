package umc.spring.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.dto.Member.MemberInfoDto;
import umc.spring.repository.MemberRepository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberQueryServiceImpl implements MemberQueryService{

    private final MemberRepository memberRepository;

    @Override
    public MemberInfoDto getUserInfo(Long userId) {
        MemberInfoDto result = memberRepository.findUserInfoById(userId);
        System.out.println("User Info: " + result);
        return result;
    }
}
