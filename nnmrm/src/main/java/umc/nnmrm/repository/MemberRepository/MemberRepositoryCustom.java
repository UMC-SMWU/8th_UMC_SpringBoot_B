package umc.nnmrm.repository.MemberRepository;

import umc.nnmrm.web.dto.Member.MyPageInfoDto;

public interface MemberRepositoryCustom {
    MyPageInfoDto getMyPageInfo(Long memberId);
}