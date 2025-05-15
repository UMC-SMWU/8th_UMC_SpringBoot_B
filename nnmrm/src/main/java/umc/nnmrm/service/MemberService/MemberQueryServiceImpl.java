package umc.nnmrm.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.nnmrm.web.dto.Member.MyPageInfoDto;
import umc.nnmrm.repository.MemberRepository.MemberRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService {

    private final MemberRepository memberRepository;

    @Override
    public MyPageInfoDto getMyPageInfo(Long memberId) {

        return memberRepository.getMyPageInfo(memberId);
    }
}