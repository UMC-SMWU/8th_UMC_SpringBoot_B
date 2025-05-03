package umc.nnmrm.repository.MemberRepository;

import umc.nnmrm.dto.MyPageInfoDto;

public interface MemberRepositoryCustom {
    MyPageInfoDto getMyPageInfo(Long memberId);
}